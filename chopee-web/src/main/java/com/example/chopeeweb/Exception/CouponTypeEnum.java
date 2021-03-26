package com.example.chopeeweb.Exception;

import lombok.Getter;

@Getter
public enum CouponTypeEnum {

    PARAMETER_ERROR(1001, "请求参数有误!"),
    UNKNOWN_ERROR(9999, "未知的错误!");

            /**
             * 状态值
             */
    private int couponType;


    /**
     * 状态描述
     */
    private String couponTypeDesc;

    CouponTypeEnum(int couponType, String couponTypeDesc){
        this.couponType = couponType;
        this.couponTypeDesc = couponTypeDesc;
    }

    public static String getDescByType(int couponType) {
        for (CouponTypeEnum type : CouponTypeEnum.values()) {
            if (type.couponType == couponType) {
                return type.couponTypeDesc;
            }
        }
        return null;
    }


    public String getcouponTypeStr(){
        return String.valueOf(this.couponType);
    }
    }
