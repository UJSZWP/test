package com.example.chopeeweb.controller;

import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.OrderInfo;
import com.example.chopeeservice.OrderService;
import com.example.chopeeweb.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 订单
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     *查询订单列表
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/getList",method = RequestMethod.POST)
    public Result<OrderInfo> getOrder(@RequestBody QueryOrderListDto queryOrderListDto) {
        OrderListDto orderListDto = orderService.SelectOrderList(queryOrderListDto);
        return Result.builder().data(orderListDto,Result.SUCCESS,"").build();

    }

    /**
     *订单发货
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/deliver",method = RequestMethod.POST)
    public Result<OrderInfo> deliverOrder(@RequestBody QueryOrderListDto queryOrderListDto) {
        orderService.deliverOrder(queryOrderListDto);
        return Result.builder().data(true,Result.SUCCESS,"").build();

    }

    /**
     *订单退款
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/refund",method = RequestMethod.POST)
    public Result<OrderInfo> refundOrder(@RequestBody QueryOrderListDto queryOrderListDto) {
        orderService.refundOrder(queryOrderListDto);
        return Result.builder().data(true,Result.SUCCESS,"").build();

    }

    /**
     *完成订单
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/complete",method = RequestMethod.POST)
    public Result<OrderInfo> completeOrder(@RequestBody QueryOrderListDto queryOrderListDto) {
        orderService.completeOrder(queryOrderListDto);
        return Result.builder().data(true,Result.SUCCESS,"").build();

    }

    /**
     * 导出部分选中的订单
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/exportSelectedOrders",method = RequestMethod.POST)
    public Result<OrderInfo> exportSelectedOrders(@RequestBody QueryOrderListDto queryOrderListDto,HttpServletResponse response) {
        orderService.exportSelectedOrders(queryOrderListDto, response);
        return Result.builder().data(true,Result.SUCCESS,"").build();

    }

    /**
     * 根据筛选条件全部导出订单列表
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/exportOrders",method = RequestMethod.POST)
    public Result<OrderInfo> exportOrders(@RequestBody QueryOrderListDto queryOrderListDto,HttpServletResponse response) {
        orderService.exportOrders(queryOrderListDto, response);
        return Result.builder().data(true,Result.SUCCESS,"").build();

    }

    /**
     * 获取销量数据
     * @param queryOrderSaleDto
     * @return
     */
    @RequestMapping(value ="/getSalesData",method = RequestMethod.POST)
    public Result<SaleDto> getSalesData(@RequestBody QueryOrderSaleDto queryOrderSaleDto, HttpServletResponse response) {
        SaleDto saleDto = new SaleDto();
               saleDto = orderService.getSalesData(queryOrderSaleDto);
        return Result.builder().data(saleDto,Result.SUCCESS,"").build();

    }

    /**
     * 立即购买商品
     * @param orderCreateDto
     * @return
     */
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public Result<SaleDto> getSalesData(@RequestBody @Validated OrderCreateDto orderCreateDto, HttpServletRequest request) {
        OrderCreateResDto orderCreateResDto = orderService.createOrder(request, orderCreateDto);
        if(null ==orderCreateResDto) {
            return Result.builder().data(false,Result.FALSE,"").build();
        }
        return Result.builder().data(orderCreateResDto,Result.SUCCESS,"").build();

    }

    /**
     * 获取订单确认页信息（订单详情信息）
     * @param confirmOrderReqDto
     * @return
     */
    @RequestMapping(value ="/confirmOrder",method = RequestMethod.POST)
    public Result<ConfirmOrderResDto> confirmOrder(@RequestBody @Validated ConfirmOrderReqDto confirmOrderReqDto) {
        ConfirmOrderResDto confirmOrderResDto = orderService.confirmOrder(confirmOrderReqDto);
        return Result.builder().data(confirmOrderResDto,Result.SUCCESS,"").build();
    }

    /**
     * 获取用户的所有订单（列表）
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/getOrderListByUser",method = RequestMethod.POST)
    public Result<OrderListDto> getOrderListByUser(@RequestBody QueryOrderListDto queryOrderListDto, HttpServletRequest request) {
        OrderListDto orderListDto = orderService.getOrderListByUser(request, queryOrderListDto);
        return Result.builder().data(orderListDto,Result.SUCCESS,"").build();
    }

    /**
     * 获取用户的所有订单（列表）
     * @param queryOrderListDto
     * @return
     */
    @RequestMapping(value ="/getOrderDetailInfo",method = RequestMethod.POST)
    public Result<OrderDetailDto> getOrderDetailInfo(@RequestBody QueryOrderListDto queryOrderListDto) {
        OrderDetailDto orderDetailDto = orderService.getOrderDetailInfoByOrderId(queryOrderListDto.getOrderId());
        return Result.builder().data(orderDetailDto,Result.SUCCESS,"").build();
    }

    /**
     * 点击支付获取支付跳转地址
     * @param confirmOrderReqDto
     * @return
     */
    @RequestMapping(value ="/confirmAddressInfo",method = RequestMethod.POST)
    public Result<ConfirmOrderResDto> confirmAddressInfo(@RequestBody ConfirmOrderReqDto confirmOrderReqDto) {
        ConfirmOrderResDto confirmOrderResDto = orderService.confirmAddressInfo(confirmOrderReqDto);
        return Result.builder().data(confirmOrderResDto,Result.SUCCESS,"").build();
    }
}
