package com.example.chopeebiz.dto;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.NotBlank;

public class LoginReqDto {
    @NotBlank(message = "登陆账号不能为空！")
    private String account;

    @NotBlank(message = "登陆密码不能为空！")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}