package com.example.chopeebiz.domain;


import com.example.chopeebiz.dto.DictDto;

import java.util.List;


public interface EnumDomain {

    /**
     * 根据type获取字典
     * @param
     * @return
     */
    List<DictDto> getDictData(String category);


}
