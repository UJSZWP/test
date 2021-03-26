package com.example.chopeebiz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryProductListDto implements Serializable{

    private Page page;
    private String productNum;
    private String productCategoryId;
    private String productStatusId;
    private String launch;


}
