package com.example.chopeeservice;

import com.example.chopeebiz.dto.LoginDto;
import com.example.chopeebiz.dto.LoginReqDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;

public interface CommonService {

    /**
     * 登陆
     */
    Cookie doLogin(LoginReqDto loginReqDto);

    /**
     * 上传文件
     */
    String uploadFile(MultipartFile file) throws Exception;

}
