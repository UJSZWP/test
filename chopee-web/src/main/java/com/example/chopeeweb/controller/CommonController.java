package com.example.chopeeweb.controller;

import com.example.chopeebiz.dto.*;
import com.example.chopeebiz.enums.UserTypeEnum;
import com.example.chopeedao.po.User;
import com.example.chopeeservice.CommonService;
import com.example.chopeeservice.UserService;
import com.example.chopeeweb.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;


/**
 *
 */
@RestController
@RequestMapping("/api/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    /**
     *登陆
     * @param
     * @return
     */
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public Result<LoginDto> getUser(@RequestBody @Validated LoginReqDto loginReqDto, HttpServletRequest request, HttpServletResponse response) {
        LoginDto loginDto = new LoginDto();
        Cookie cookie = commonService.doLogin(loginReqDto);
        if(null == cookie) {
            return Result.builder().data(false, Result.RELOGIN, "").build();
        }
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        loginDto.setCookie(cookie.getValue());
        return Result.builder().data(loginDto, Result.SUCCESS, "").build();
    }

    /**
     * 上传图片
     * @param
     * @return
     */
    @RequestMapping(value ="/uploadPhoto",method = RequestMethod.POST)
    public Result<FilePathDto> uploadPhoto(@RequestParam("file") MultipartFile file) {
        FilePathDto filePathDto = new FilePathDto();
        String filePath = null;
        try {
            filePath = commonService.uploadFile(file);
        } catch (Exception e) {
        }
        if(StringUtils.isBlank(filePath)) {
            return Result.builder().data(false, Result.FAILED, "").build();
        }
        return Result.builder().data(filePath, Result.SUCCESS, "").build();
    }
}
