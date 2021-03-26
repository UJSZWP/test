package com.example.chopeebiz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDetailDto implements Serializable{
    private Integer id;
    private String productNum;
    private String productName;
    private String coverPhotoUrl;
    private String[] detailPhotoUrl;
    private String productPrice;
    private String expressPrice;
    private String productCategoryId;
    private String productCategoryName;
    private String[] sizeList;
    private String[] colorList;
}
