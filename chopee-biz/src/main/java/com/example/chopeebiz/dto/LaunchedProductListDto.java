package com.example.chopeebiz.dto;

import lombok.Data;

import java.util.List;

@Data
public class LaunchedProductListDto {
    private Page page;

    private List<LaunchedProductDto> launchedProductDtoList;


}