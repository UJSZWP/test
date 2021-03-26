package com.example.chopeebiz.dto;


import com.example.chopeedao.po.User;
import lombok.Data;
import java.util.List;

@Data
public class UserListDto {

    private List<User> userList;
    private Page page;

}
