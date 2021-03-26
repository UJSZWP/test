package com.example.chopeebiz.domain.Impl;


import com.example.chopeebiz.domain.OrderDomain;
import com.example.chopeebiz.dto.*;
import com.example.chopeedao.mapper.OrderInfoMapper;
import com.example.chopeedao.mapper.ProductMapper;
import com.example.chopeedao.po.OrderInfo;
import com.example.chopeedao.po.OrderInfoExample;
import com.example.chopeebiz.enums.OrderStatusEnum;
import com.example.chopeedao.po.Product;
import com.example.chopeedao.po.ProductExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



@Component

public class orderDomainImpl implements OrderDomain {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrderListDto SelectOrderList(QueryOrderListDto queryOrderListDto) {
        OrderListDto orderListDto = new OrderListDto();
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();

        criteria.andIsDeleteEqualTo("0");
        if(null != queryOrderListDto.getProductId()) {
            criteria.andProductIdEqualTo(queryOrderListDto.getProductId());
        }
        if(null != queryOrderListDto.getOrderId()) {
            criteria.andIdEqualTo(queryOrderListDto.getOrderId());
        }
        if(StringUtil.isNotEmpty(queryOrderListDto.getOrderStatus())) {
            criteria.andOrderStatusEqualTo(queryOrderListDto.getOrderStatus());
        }
        Date startTime = null;
        Date endTime = null;
        try {
            if(null != queryOrderListDto.getOrderCreateTime()) {
                startTime = StringToDate(queryOrderListDto.getOrderCreateTime());
                endTime = addOneDay(startTime);
            }
        } catch (ParseException e) {
    }
        if(null != startTime && null != endTime) {
            criteria.andAddTimeBetween(startTime, endTime);
        }
        // 分页查询
        PageHelper.startPage(queryOrderListDto.getPage().getPageNo(), queryOrderListDto.getPage().getPageSize());
        List<OrderInfo> orderList = orderInfoMapper.selectByExample(example);
        PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(orderList);
        // 取出页数
        Page page = queryOrderListDto.getPage();
        page.setTotalCount((int) pageInfo.getTotal());
        page.setTotal(pageInfo.getPages());
        orderListDto.setPage(page);
        orderListDto.setOrderInfoList(orderList);
        return orderListDto;
    }

    @Override
    public void deliverOrder(QueryOrderListDto queryOrderListDto) {
        OrderInfo order = new OrderInfo();
        order.setId(queryOrderListDto.getOrderId());
        order.setExpressInfo(queryOrderListDto.getExpressInfo());
        order.setOrderStatus(OrderStatusEnum.PENDING_RECEIVE.getCode());
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andIdEqualTo(order.getId())
                .andIsDeleteEqualTo("0");
        orderInfoMapper.updateByExampleSelective(order, example);
    }

    @Override
    public void refundOrder(QueryOrderListDto queryOrderListDto) {
        OrderInfo order = new OrderInfo();
        order.setId(queryOrderListDto.getOrderId());
        order.setRefundAmount(queryOrderListDto.getRefundAmount());
        order.setOrderStatus(OrderStatusEnum.REFUNDED.getCode());
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andIdEqualTo(order.getId())
                .andIsDeleteEqualTo("0");
        orderInfoMapper.updateByExampleSelective(order, example);
    }

    @Override
    public void completeOrder(QueryOrderListDto queryOrderListDto) {
        OrderInfo order = new OrderInfo();
        order.setId(queryOrderListDto.getOrderId());
        order.setOrderStatus(OrderStatusEnum.COMPLETED.getCode());
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andIdEqualTo(order.getId())
                .andIsDeleteEqualTo("0");
        orderInfoMapper.updateByExampleSelective(order, example);
    }

    @Override
    public List<OrderInfo> getSelectedOrders(QueryOrderListDto queryOrderListDto) {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andIdIn(Arrays.asList(queryOrderListDto.getOrderIds()))
                .andIsDeleteEqualTo("0");
        orderInfoList = orderInfoMapper.selectByExample(example);
        return orderInfoList;
    }

    @Override
    public SaleDto getSalesData(QueryOrderSaleDto queryOrderSaleDto) {
        SaleDto saleDto = new SaleDto();
        OrderInfoExample example = new OrderInfoExample();
        OrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo("0");
        if(null != queryOrderSaleDto.getProductId()) {
            criteria.andProductIdEqualTo(queryOrderSaleDto.getProductId());
        }

        Date startTime = null;
        Date endTime = null;
        try {
            if(null != queryOrderSaleDto.getStartTime()) {
                startTime = StringToDate(queryOrderSaleDto.getStartTime());
            }
            if(null != queryOrderSaleDto.getEndTime()) {
                endTime = StringToDate(queryOrderSaleDto.getEndTime());
            }
        } catch (ParseException e) {
        }

        if(null != startTime && null != endTime) {
            criteria.andAddTimeBetween(startTime, endTime);
        }

        if(null != queryOrderSaleDto.getOrderStatus()) {
            criteria.andOrderStatusIn(Arrays.asList(queryOrderSaleDto.getOrderStatus()));
        }

        List<OrderInfo> orderList = orderInfoMapper.selectByExample(example);
        double totalOrders = 0;
        int orderAmount = 0;
        for(OrderInfo orderInfo:orderList) {
            if(StringUtil.isNotEmpty(orderInfo.getOrderAmount())) {
                totalOrders += Double.parseDouble(orderInfo.getOrderAmount());
            }
            if(StringUtil.isNotEmpty(orderInfo.getAmount())) {
                orderAmount += Integer.parseInt(orderInfo.getAmount());
            }
        }
        saleDto.setTotalOrders(totalOrders);
        saleDto.setOrderAmount(orderAmount);
        return saleDto;
    }

    @Override
    public OrderCreateResDto createOrder(OrderInfo orderInfo) {
        orderInfoMapper.insertSelective(orderInfo);
        OrderCreateResDto orderCreateResDto = new OrderCreateResDto();
        orderCreateResDto.setOrderId(orderInfo.getId());
        return orderCreateResDto;
    }

    @Override
    public ConfirmOrderResDto confirmOrder(ConfirmOrderReqDto confirmOrderReqDto) {
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andIdEqualTo(confirmOrderReqDto.getOrderId())
                .andIsDeleteEqualTo("0");
        List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(example);
        ConfirmOrderResDto confirmOrderResDto = new ConfirmOrderResDto();
        if(CollectionUtils.isEmpty(orderInfoList)) {
            return null;
        }
        OrderInfo orderInfo = orderInfoList.get(0);
        BeanUtils.copyProperties(orderInfo, confirmOrderResDto);

        ProductExample productExample = new ProductExample();
        example.createCriteria().andIsDeleteEqualTo("0")
                .andProductNumEqualTo(orderInfo.getProductNum());
        List<Product> productList = productMapper.selectByExample(productExample);
        confirmOrderResDto.setCoverPhotoUrl(productList.get(0).getPhotoUrl());

        return confirmOrderResDto;
    }

    @Override
    public OrderListDto getOrderListByUser(QueryOrderListDto queryOrderListDto) {
        OrderListDto orderListDto = new OrderListDto();
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andCustomerIdEqualTo(queryOrderListDto.getUserId())
                .andIsDeleteEqualTo("0");
        // 分页查询
        PageHelper.startPage(queryOrderListDto.getPage().getPageNo(), queryOrderListDto.getPage().getPageSize());
        List<OrderInfo> orderList = orderInfoMapper.selectByExample(example);
        orderList.stream().forEach(o -> {
            String orderStatusName = OrderStatusEnum.fromCode(o.getOrderStatus()).getName();
            o.setOrderStatus(orderStatusName);
        });
        PageInfo<OrderInfo> pageInfo = new PageInfo<OrderInfo>(orderList);
        // 取出页数
        Page page = queryOrderListDto.getPage();
        page.setTotalCount((int) pageInfo.getTotal());
        page.setTotal(pageInfo.getPages());
        orderListDto.setPage(page);
        orderListDto.setOrderInfoList(orderList);
        return orderListDto;
    }

    @Override
    public OrderDetailDto getOrderDetailInfoByOrderId(Integer orderId) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        OrderInfoExample example = new OrderInfoExample();
        example.createCriteria().andIdEqualTo(orderId)
                .andIsDeleteEqualTo("0");
        List<OrderInfo> orderList = orderInfoMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(orderList)) {
            return null;
        }
        OrderInfo orderInfo = orderList.get(0);
        String orderStatusName = OrderStatusEnum.fromCode(orderInfo.getOrderStatus()).getName();
        orderInfo.setOrderStatus(orderStatusName);
        BeanUtils.copyProperties(orderInfo, orderDetailDto);
        orderDetailDto.setOrderId(orderInfo.getId());
        return orderDetailDto;
    }

    @Override
    public void confirmAddressInfo(ConfirmOrderReqDto confirmOrderReqDto) {
        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderInfo, confirmOrderReqDto);
        orderInfo.setId(confirmOrderReqDto.getOrderId());
        orderInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public List<OrderInfo> SelectUnCompletedOrderList() {
        List<OrderInfo> orderList = new ArrayList<>();
        OrderInfoExample example = new OrderInfoExample();
        Date date = fifteenDaysToday();
        example.createCriteria().andOrderStatusEqualTo(OrderStatusEnum.PENDING_RECEIVE.getCode())
                .andIsDeleteEqualTo("0")
                .andOrderCreateTimeLessThan(date);
        orderList = orderInfoMapper.selectByExample(example);
        return orderList;
    }





    private Date fifteenDaysToday() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //此时的日期为15天前
        calendar.add(Calendar.DATE, -15);
        return calendar.getTime();
    }

    private Date StringToDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(str);
        return date;
    }

    private Date addOneDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime();
    }
}
