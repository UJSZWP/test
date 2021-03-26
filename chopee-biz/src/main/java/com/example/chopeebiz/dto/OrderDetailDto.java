package com.example.chopeebiz.dto;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDetailDto {
    private Integer orderId;

    private String orderNum;

    private Integer productId;

    private String productNum;

    private String productName;

    private String orderAmount;

    private String refundAmount;

    private String orderCreateTime;

    private String size;

    private String color;

    private String amount;

    private String addressInfo;

    private String expressInfo;

    private String orderStatus;

    private String comment;

    private String productPrice;

    private String expressPrice;


}