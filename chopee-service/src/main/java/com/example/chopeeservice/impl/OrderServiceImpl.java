package com.example.chopeeservice.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.example.chopeebiz.domain.OrderDomain;
import com.example.chopeebiz.domain.ProductDomain;
import com.example.chopeebiz.domain.UserDomain;
import com.example.chopeebiz.dto.*;
import com.example.chopeebiz.enums.OrderStatusEnum;
import com.example.chopeedao.po.OrderInfo;
import com.example.chopeedao.po.User;
import com.example.chopeeservice.OrderService;
import com.example.chopeeservice.dto.ExcelOrderDto;
import com.example.chopeeservice.util.EncryptionUtil;
import com.example.chopeeservice.util.ExcelUtil;
import com.example.chopeeservice.util.IdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.io.IOException;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDomain orderDomain;

    @Autowired
    private UserDomain userDomain;

    @Autowired
    private ProductDomain productDomain;

    @Override
    public OrderListDto SelectOrderList(QueryOrderListDto queryOrderListDto) {
        OrderListDto orderListDto = orderDomain.SelectOrderList(queryOrderListDto);
        return orderListDto;
    }

    @Override
    public void deliverOrder(QueryOrderListDto queryOrderListDto) {
        orderDomain.deliverOrder(queryOrderListDto);
    }

    @Override
    public void refundOrder(QueryOrderListDto queryOrderListDto) {
        orderDomain.refundOrder(queryOrderListDto);
    }

    @Override
    public void completeOrder(QueryOrderListDto queryOrderListDto) {
        orderDomain.completeOrder(queryOrderListDto);
    }

    @Override
    public void exportOrders(QueryOrderListDto queryOrderListDto,HttpServletResponse response) {
        OrderListDto orderListDto = orderDomain.SelectOrderList(queryOrderListDto);
        List<OrderInfo> orderInfoList = orderListDto.getOrderInfoList();
        try {
            exportExcel(orderInfoList,response);
        } catch(IOException e){
            System.out.println("导出excel失败");
        }
    }

    @Override
    public void exportSelectedOrders(QueryOrderListDto queryOrderListDto,HttpServletResponse response) {
        List<OrderInfo> orderInfoList = orderDomain.getSelectedOrders(queryOrderListDto);
        try {
            exportExcel(orderInfoList,response);
        } catch(IOException e){
            System.out.println("导出excel失败");
        }
    }

    private void exportExcel(List<OrderInfo> orderInfoList,HttpServletResponse response) throws IOException {
        List<ExcelOrderDto> data = orderInfoList.stream().map(o -> {
            ExcelOrderDto excelOrderDto = new ExcelOrderDto();
            BeanUtils.copyProperties(o, excelOrderDto);
            OrderStatusEnum orderStatusEnum = OrderStatusEnum.fromCode(o.getOrderStatus());
            if(null != orderStatusEnum) {
                excelOrderDto.setOrderStatus(orderStatusEnum.getName());
            }
            return excelOrderDto;
        }).collect(Collectors.toList());

        ExcelUtil.writeExcel(response, data, "导出", ExcelOrderDto.class);
    }

    @Override
    public SaleDto getSalesData(QueryOrderSaleDto queryOrderSaleDto) {
        SaleDto saleDto = new SaleDto();
        saleDto = orderDomain.getSalesData(queryOrderSaleDto);
        return saleDto;
    }

    @Override
    public OrderCreateResDto createOrder(HttpServletRequest request, OrderCreateDto orderCreateDto) {
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderCreateDto, orderInfo);

        Integer userId = EncryptionUtil.getUserIdFromCookie(request);

        User user = new User();
        user = userDomain.SelectUserRole(userId);
        orderInfo.setCustomerId(userId);
        orderInfo.setCustomerName(user.getUserName());
        orderInfo.setId(Integer.valueOf(IdUtil.getUUIDInOrderId()));
        orderInfo.setOrderNum(IdUtil.getUUIDInOrderId().toString());

        // 计算订单价格
        QueryProductListDto queryProductListDto = new QueryProductListDto();
        queryProductListDto.setProductNum(orderCreateDto.getProductNum());
        ProductDetailDto productDetailDto = productDomain.getProductDetailInfo(queryProductListDto);
        if(null == productDetailDto) {
            return null;
        }
        orderInfo.setExpressPrice(productDetailDto.getExpressPrice());
        orderInfo.setProductPrice(productDetailDto.getProductPrice());
        orderInfo.setProductId(productDetailDto.getId());
        orderInfo.setProductName(productDetailDto.getProductName());
        orderInfo.setOrderAmount(String.valueOf(Double.parseDouble(productDetailDto.getProductPrice())*Double.parseDouble(orderInfo.getAmount())));

        OrderCreateResDto orderCreateResDto = orderDomain.createOrder(orderInfo);
        return orderCreateResDto;
    }

    @Override
    public ConfirmOrderResDto confirmOrder(ConfirmOrderReqDto confirmOrderReqDto) {
        ConfirmOrderResDto confirmOrderResDto = orderDomain.confirmOrder(confirmOrderReqDto);
        return confirmOrderResDto;
    }

    @Override
    public OrderListDto getOrderListByUser(HttpServletRequest request, QueryOrderListDto queryOrderListDto) {
        EncryptionUtil.getUserIdFromCookie(request);
        Integer userId = EncryptionUtil.getUserIdFromCookie(request);
        if(null == userId) {
            return null;
        }
        queryOrderListDto.setUserId(userId);
        OrderListDto orderListDto = orderDomain.getOrderListByUser(queryOrderListDto);
        return orderListDto;
    }

    @Override
    public OrderDetailDto getOrderDetailInfoByOrderId(Integer orderId) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto = orderDomain.getOrderDetailInfoByOrderId(orderId);
        return orderDetailDto;
    }

    @Override
    public ConfirmOrderResDto confirmAddressInfo(ConfirmOrderReqDto confirmOrderReqDto) {
        ConfirmOrderResDto confirmOrderResDto = new ConfirmOrderResDto();
        orderDomain.confirmAddressInfo(confirmOrderReqDto);
        return confirmOrderResDto;
    }

    @Override
    public List<OrderInfo> SelectUnCompletedOrderList() {
        List<OrderInfo> orderInfoList = orderDomain.SelectUnCompletedOrderList();
        return orderInfoList;
    }



}
