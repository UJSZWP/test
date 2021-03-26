package com.example.chopeebiz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfirmOrderResDto implements Serializable{

    private String productPrice;
    private String productNum;
    private String expressPrice;
    private String productName;
    private String coverPhotoUrl;
    private String color;
    private String amount;
    private String orderAmount;



}
