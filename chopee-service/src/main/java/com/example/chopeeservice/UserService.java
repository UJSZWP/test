package com.example.chopeeservice;

import com.example.chopeebiz.dto.RegisterReqDto;
import com.example.chopeebiz.dto.UserListDto;
import com.example.chopeedao.po.User;
import com.example.chopeebiz.dto.QueryUserListDto;
import com.example.chopeeservice.dto.UserRoleDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    /**
     * 根据type获取用户列表
     */
    UserListDto SelectUserList(QueryUserListDto queryUserListDto);

    /**
     * 获取用户信息
     */
   UserRoleDto getUserInfo (HttpServletRequest request);

    /**
     * 用户注册
     */
    void register(RegisterReqDto registerReqDto);
}
