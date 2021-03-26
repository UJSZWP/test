package com.example.chopeeservice;

import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.OrderInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface OrderService {

    /**
     * 获取订单列表
     */
    OrderListDto SelectOrderList(QueryOrderListDto queryOrderListDto);

    /**
     * 订单发货
     */
    void deliverOrder(QueryOrderListDto queryOrderListDto);

    /**
     * 订单退款
     */
    void refundOrder(QueryOrderListDto queryOrderListDto);

    /**
     * 完成订单
     */
    void completeOrder(QueryOrderListDto queryOrderListDto);

    /**
     * 导出部分选中的订单
     */
    void exportSelectedOrders(QueryOrderListDto queryOrderListDto,HttpServletResponse response);

    /**
     * 根据筛选条件全部导出订单列表
     */
    void exportOrders(QueryOrderListDto queryOrderListDto,HttpServletResponse response);

    /**
     * 获取销量数据
     */
    SaleDto getSalesData(QueryOrderSaleDto queryOrderSaleDto);

    /**
     * 立即购买商品
     */
    OrderCreateResDto createOrder(HttpServletRequest request, OrderCreateDto orderCreateDto);

    /**
     * 获取订单确认页信息（订单详情信息）
     */
    ConfirmOrderResDto confirmOrder(ConfirmOrderReqDto confirmOrderReqDto);

    /**
     * 获取用户的所有订单（列表）
     */
    OrderListDto getOrderListByUser(HttpServletRequest request, QueryOrderListDto queryOrderListDto);

    /**
     * 获取订单详情信息
     */
    OrderDetailDto getOrderDetailInfoByOrderId(Integer orderId);

    /**
     * 点击支付获取支付跳转地址
     */
    ConfirmOrderResDto confirmAddressInfo(ConfirmOrderReqDto confirmOrderReqDto);

    /**
     * 获取发货时间到期，未确认订单
     */
    List<OrderInfo> SelectUnCompletedOrderList();
}
