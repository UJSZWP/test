package com.example.chopeebiz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryOrderSaleDto implements Serializable{

    private Integer productId;
    private Integer orderId;
    private String startTime;
    private String endTime;
    private String[] orderStatus;




}
