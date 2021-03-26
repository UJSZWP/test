package com.example.chopeebiz.domain.Impl;


import com.example.chopeebiz.domain.UserDomain;
import com.example.chopeebiz.domain.util.IdUtil;
import com.example.chopeebiz.dto.*;
import com.example.chopeebiz.enums.UserTypeEnum;
import com.example.chopeedao.mapper.UserMapper;
import java.text.SimpleDateFormat;

import com.example.chopeedao.po.User;
import com.example.chopeedao.po.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;


@Component

public class UserDomainImpl implements UserDomain {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserListDto SelectUserList(QueryUserListDto queryUserListDto) {
        UserListDto userListDto = new UserListDto();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUserTypeEqualTo(queryUserListDto.getUserType())
                .andIsDeleteEqualTo("0");
        if(null != queryUserListDto.getUserName()) {
            criteria.andUserNameLike(queryUserListDto.getUserName());
        }
        if(null != queryUserListDto.getUserId()) {
            criteria.andUserIdEqualTo(queryUserListDto.getUserId());
        }
        if(null != queryUserListDto.getEmail() ) {
            criteria.andEmailEqualTo(queryUserListDto.getEmail());
        }
        Date startTime = null;
        Date endTime = null;
        try {
            if(null != queryUserListDto.getStartTime()) {
                startTime = StringToDate(queryUserListDto.getStartTime());
            }
            if(null != queryUserListDto.getEndTime()) {
                endTime = StringToDate(queryUserListDto.getEndTime());
            }
        } catch (ParseException e) {
    }
        if(null != startTime && null != endTime) {
            criteria.andAddTimeBetween(startTime, endTime);
        }
        // 分页查询
        PageHelper.startPage(queryUserListDto.getPage().getPageNo(), queryUserListDto.getPage().getPageSize());
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        // 取出页数
        Page page = queryUserListDto.getPage();
        page.setTotalCount((int) pageInfo.getTotal());
        page.setTotal(pageInfo.getPages());
        userListDto.setPage(page);
        userListDto.setUserList(userList);
        return userListDto;
    }

    private Date StringToDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(str);
        return date;
    }

    @Override
    public User doLogin(LoginReqDto loginReqDto) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(loginReqDto.getAccount())
        .andPasswordEqualTo(loginReqDto.getPassword())
        .andIsDeleteEqualTo("0");
        List<User> userList = userMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User SelectUserRole(Integer userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(userId)
                .andIsDeleteEqualTo("0");

        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public void register(RegisterReqDto registerReqDto) {
        User user = new User();
        BeanUtils.copyProperties(registerReqDto, user);
        user.setUserId(IdUtil.getUUIDInOrderId());
        userMapper.insertSelective(user);
    }

}
