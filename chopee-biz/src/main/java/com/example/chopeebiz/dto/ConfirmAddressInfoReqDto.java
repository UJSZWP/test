package com.example.chopeebiz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfirmAddressInfoReqDto implements Serializable{

    private Integer orderId;

    private String addressCode;

    private String addressInfo;

    private String comment;

}
