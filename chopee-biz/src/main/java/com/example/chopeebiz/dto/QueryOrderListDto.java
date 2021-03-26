package com.example.chopeebiz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryOrderListDto implements Serializable{

    private Integer userId;
    private Integer productId;
    private Integer orderId;
    private String orderCreateTime;
    private String orderStatus;
    private String expressInfo;
    private String refundAmount;
    private Integer[] orderIds;
    private Page page;



}
