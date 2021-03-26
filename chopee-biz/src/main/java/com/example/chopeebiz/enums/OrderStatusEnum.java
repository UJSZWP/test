package com.example.chopeebiz.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatusEnum {

    CANCELED("1", "已取消"),
    REFUND("2", "退款"),
    PENDING_PAYMENT("3", "待支付"),
    PENDING_DELIVER("4", "待发货"),
    REFUNDED("5", "已退款"),
    PENDING_RECEIVE("6", "待收货"),
    COMPLETED("7", "已完成");


    private String code;
    private String name;

    public static OrderStatusEnum fromCode(String code) {
        for(OrderStatusEnum orderStatusEnum : values()) {
            if(orderStatusEnum.getCode().equals(code) ) {
                return orderStatusEnum;
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
