package com.example.chopeebiz.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class OrderCreateDto implements Serializable{
    @NotBlank(message = "商品编号不能为空！")
    private String productNum;

    @NotBlank(message = "商品颜色不能为空！")
    private String color;

    @NotBlank(message = "商品型号不能为空！")
    private String size;

    @NotBlank(message = "购买数量不能为空！")
    private String amount;


}
