package com.example.chopeeservice;

import com.example.chopeebiz.dto.QueryUserListDto;
import com.example.chopeebiz.dto.DictDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EnumService {

    /**
     * 根据type获取字典
     */
    List<DictDto> getDictData(String category);


}
