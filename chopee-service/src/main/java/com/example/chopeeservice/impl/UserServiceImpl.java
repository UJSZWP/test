package com.example.chopeeservice.impl;

import com.example.chopeebiz.domain.UserDomain;
import com.example.chopeebiz.dto.QueryUserListDto;
import com.example.chopeebiz.dto.RegisterReqDto;
import com.example.chopeebiz.dto.UserListDto;
import com.example.chopeedao.po.User;
import com.example.chopeeservice.UserService;
import com.example.chopeeservice.dto.UserRoleDto;
import com.example.chopeeservice.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDomain userDomain;

    @Override
    public UserListDto SelectUserList(QueryUserListDto queryUserListDto) {
        UserListDto userListDto = userDomain.SelectUserList(queryUserListDto);
        return userListDto;
    }

    @Override
    public UserRoleDto getUserInfo (HttpServletRequest request) {
        Integer userId = EncryptionUtil.getUserIdFromCookie(request);

        User user = new User();
        user = userDomain.SelectUserRole(userId);
        if (null != user) {
            UserRoleDto userRoleDto = new UserRoleDto();
            userRoleDto.setUserId(user.getUserId());
            userRoleDto.setAccount(user.getUserName());
            userRoleDto.setUserRoleId(user.getUserType());
            return userRoleDto;
        }
        return null;
    }

    @Override
    public void register(RegisterReqDto registerReqDto) {
        userDomain.register(registerReqDto);
    }
}
