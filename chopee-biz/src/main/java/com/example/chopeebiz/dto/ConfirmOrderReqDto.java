package com.example.chopeebiz.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ConfirmOrderReqDto implements Serializable{
    @NotBlank(message = "订单id不能为空！")
    private Integer orderId;



}
