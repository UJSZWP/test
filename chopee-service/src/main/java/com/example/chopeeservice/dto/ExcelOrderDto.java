package com.example.chopeeservice.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import java.util.Date;

public class ExcelOrderDto {
    @ExcelProperty(value = "订单id", index = 0)
    private Integer id;

    @ExcelProperty(value = "订单编码", index = 1)
    private String orderNum;

    @ExcelProperty(value = "下单用户ID", index = 2)
    private Integer customerId;

    @ExcelProperty(value = "用户姓名", index = 3)
    private String customerName;

    @ExcelProperty(value = "商品ID", index = 4)
    private Integer productId;

    @ExcelProperty(value = "商品编码", index = 5)
    private String productNum;

    @ExcelProperty(value = "商品名称", index = 6)
    private String productName;

    @ExcelProperty(value = "支付金额", index = 7)
    private String orderAmount;

    @ExcelProperty(value = "退款金额", index = 8)
    private String refundAmount;

    @ExcelProperty(value = "下单时间", index = 9)
    private String orderCreateTime;

    @ExcelProperty(value = "大小", index = 10)
    private String size;

    @ExcelProperty(value = "颜色", index = 11)
    private String color;

    @ExcelProperty(value = "数量", index = 12)
    private String amount;

    @ExcelProperty(value = "收货信息", index = 13)
    private String addressInfo;

    @ExcelProperty(value = "物流信息", index = 14)
    private String expressInfo;

    @ExcelProperty(value = "订单状态", index = 15)
    private String orderStatus;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum == null ? null : productNum.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount == null ? null : orderAmount.trim();
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount == null ? null : refundAmount.trim();
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo == null ? null : addressInfo.trim();
    }

    public String getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(String expressInfo) {
        this.expressInfo = expressInfo == null ? null : expressInfo.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

}