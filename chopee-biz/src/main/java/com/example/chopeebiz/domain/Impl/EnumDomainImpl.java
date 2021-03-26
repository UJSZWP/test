package com.example.chopeebiz.domain.Impl;


import com.example.chopeebiz.domain.EnumDomain;
import com.example.chopeebiz.dto.DictDto;
import com.example.chopeedao.mapper.Dict_DataMapper;
import com.example.chopeedao.po.Dict_Data;
import com.example.chopeedao.po.Dict_DataExample;
import com.example.chopeedao.po.User;
import com.example.chopeedao.po.UserExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Component

public class EnumDomainImpl implements EnumDomain {

    @Autowired
    private Dict_DataMapper dictDataMapper;

    @Override
    public List<DictDto> getDictData(String category) {
        Dict_DataExample example = new Dict_DataExample();
        example.createCriteria().andCategoryEqualTo(category)
                .andIsDeleteEqualTo(Boolean.FALSE);

        List<Dict_Data> dictDataList = dictDataMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(dictDataList)) {
            return null;
        }
        List<DictDto> dictDtoList = dictDataList.stream().map(d -> {
            DictDto dictDto = new DictDto();
            BeanUtils.copyProperties(d, dictDto);
            return dictDto;
        })
                .collect(Collectors.toList());
        return dictDtoList;
    }
}
