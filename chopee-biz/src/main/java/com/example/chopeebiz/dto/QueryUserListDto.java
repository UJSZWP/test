package com.example.chopeebiz.dto;

import com.example.chopeebiz.dto.Page;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryUserListDto implements Serializable{

    private Integer userId;
    private Page page;
    private String userName;
    private String email;
    private String startTime;
    private String endTime;
    private String userType;


}
