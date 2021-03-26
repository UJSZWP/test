package com.example.chopeeservice.impl;

import com.example.chopeebiz.domain.EnumDomain;
import com.example.chopeebiz.dto.DictDto;
import com.example.chopeeservice.EnumService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnumServiceImpl implements EnumService {

    @Autowired
    private EnumDomain enumDomain;

    @Override
    public List<DictDto> getDictData(String category) {
        List<DictDto> dictDtoList = enumDomain.getDictData(category);
        return dictDtoList;
    }
}
