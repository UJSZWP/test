package com.example.chopeebiz.dto;


import com.example.chopeedao.po.OrderInfo;
import lombok.Data;

import java.util.List;

@Data
public class OrderListDto {

    private List<OrderInfo> orderInfoList;
    private Page page;

}
