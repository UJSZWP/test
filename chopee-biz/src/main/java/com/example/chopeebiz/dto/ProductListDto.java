package com.example.chopeebiz.dto;


import com.example.chopeedao.po.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductListDto {

    private List<Product> productList;
    private Page page;

}
