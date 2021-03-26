package com.example.chopeebiz.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductCategoryEnum {

    WOMEN_CLOTHING("1", "女装"),
    MEN_CLOTHING("2", "男装"),
    BAG("3", "包包"),
    SHOE("4", "鞋子"),
    ACCESSORIES("5", "配饰");

    private String code;
    private String name;

    public static ProductCategoryEnum fromCode(String code) {
        for(ProductCategoryEnum productCategoryEnum : values()) {
            if(productCategoryEnum.getCode().equals(code) ) {
                return productCategoryEnum;
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
