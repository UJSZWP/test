package com.example.chopeeweb.controller;

import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.User;
import com.example.chopeebiz.enums.UserTypeEnum;
import com.example.chopeeservice.UserService;
import com.example.chopeeservice.dto.UserRoleDto;
import com.example.chopeeweb.Result;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *查询普通用户列表
     * @param queryUserListDto
     * @return
     */
    @RequestMapping(value ="/getList",method = RequestMethod.POST)
    public Result<User> getUser(@RequestBody QueryUserListDto queryUserListDto) {

        queryUserListDto.setUserType(UserTypeEnum.CUSTOMER.getCode());
        UserListDto userListDto = userService.SelectUserList(queryUserListDto);
        return Result.builder().data(userListDto,Result.SUCCESS,"").build();

    }

    /**
     * 返回用户个人信息
     * @param
     * @return
     */
    @RequestMapping(value ="/getUserInfo",method = RequestMethod.POST)
    public Result<UserRoleDto> getUser(HttpServletRequest request) {
        UserRoleDto userRoleDto = userService.getUserInfo(request);
        if(null == userRoleDto) {
            return Result.builder().data(false, Result.RELOGIN, "").build();
        }
        return Result.builder().data(userRoleDto, Result.SUCCESS, "").build();
    }

    /**
     * 注册
     * @param
     * @return
     */
    @RequestMapping(value ="/register",method = RequestMethod.POST)
    public Result<User> register(@RequestBody @Validated RegisterReqDto registerReqDto) {
        userService.register(registerReqDto);
        return Result.builder().data(true, Result.SUCCESS, "").build();
    }
}
