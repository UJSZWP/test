package com.example.chopeebiz.domain;


import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.User;

public interface UserDomain {

    /**
     * 根据查询条件获取用户列表
     * @param queryUserListDto
     * @return
     */
    UserListDto SelectUserList(QueryUserListDto queryUserListDto);

    /**
     * 登陆
     */
    User doLogin(LoginReqDto loginReqDto);

    /**
     * 获取用户角色
     */
    User SelectUserRole(Integer userId);

    /**
     * 用户注册
     */
    void register(RegisterReqDto registerReqDto);
}
