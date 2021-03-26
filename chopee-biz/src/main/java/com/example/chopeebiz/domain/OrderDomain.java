package com.example.chopeebiz.domain;


import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.OrderInfo;

import java.util.List;

public interface OrderDomain {

    /**
     * 根据查询条件获取订单列表
     * @param queryOrderListDto
     * @return
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
     * 部分选中的订单
     */
    List<OrderInfo> getSelectedOrders(QueryOrderListDto queryOrderListDto);

    /**
     * 获取销量数据
     */
    SaleDto getSalesData(QueryOrderSaleDto queryOrderSaleDto);

    /**
     * 立即购买商品
     */
    OrderCreateResDto createOrder(OrderInfo orderInfo);

    /**
     * 获取订单确认页信息（订单详情信息）
     */
    ConfirmOrderResDto confirmOrder(ConfirmOrderReqDto confirmOrderReqDto);

    /**
     * 获取用户的所有订单（列表）
     */
    OrderListDto getOrderListByUser(QueryOrderListDto queryOrderListDto);

    /**
     * 获取订单详情信息
     */
    OrderDetailDto getOrderDetailInfoByOrderId(Integer orderId);

    /**
     * 点击支付获取支付跳转地址
     */
    void confirmAddressInfo(ConfirmOrderReqDto confirmOrderReqDto);

    /**
     * 获取发货时间到期，未确认订单
     */
    List<OrderInfo> SelectUnCompletedOrderList();

}
