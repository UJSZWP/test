package com.example.chopeebiz.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegisterReqDto implements Serializable{
    @NotBlank(message = "账号不能为空！")
    private String userName;

    @NotBlank(message = "密码不能为空！")
    private String password;

    @NotBlank(message = "邮箱不能为空！")
    private String email;

}
