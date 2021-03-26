package com.example.chopeebiz.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum UserTypeEnum {

    ADMIN("1", "管理员"),
    CUSTOM_SERVICE("2", "客服"),
    CUSTOMER("3", "顾客");


    private String code;
    private String name;


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
