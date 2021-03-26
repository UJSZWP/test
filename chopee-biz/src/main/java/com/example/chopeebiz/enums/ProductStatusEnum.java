package com.example.chopeebiz.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductStatusEnum {

    PUll_OFF_SHELVES("0", "下架"),
    PUT_ON_SHELVES("1", "上架");

    private String code;
    private String name;

    public static ProductStatusEnum fromCode(String code) {
        for(ProductStatusEnum productStatusEnum : values()) {
            if(productStatusEnum.getCode().equals(code) ) {
                return productStatusEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
