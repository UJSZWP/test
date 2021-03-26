package com.example.chopeeservice.impl;

import com.example.chopeebiz.domain.ProductDomain;
import com.example.chopeebiz.dto.*;
import com.example.chopeebiz.enums.ProductStatusEnum;
import com.example.chopeedao.po.Product;
import com.example.chopeeservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDomain productDomain;

    @Override
    public ProductListDto selectProductList(QueryProductListDto queryProductListDto) {
        ProductListDto userListDto = productDomain.SelectProductList(queryProductListDto);
        return userListDto;
    }

    @Override
    public void deleteProductByProductNum(String productNum) {
        productDomain.deleteProductByProductNum(productNum);
    }

    @Override
    public void updateProductByProductNum(QueryProductListDto queryProductListDto) {
        Product product = new Product();
        product.setProductStatusId(queryProductListDto.getLaunch());
        ProductStatusEnum productStatusEnum = ProductStatusEnum.fromCode(queryProductListDto.getLaunch());
        product.setProductStatusName(productStatusEnum.getName());
        productDomain.updateProductByProductNum(queryProductListDto.getProductNum(), product);
    }

    @Override
    public void insertOrUpdateProduct(ProductInsertDto productInsertDto) {
        productDomain.insertOrUpdateProduct(productInsertDto);
    }

    @Override
    public LaunchedProductListDto getLaunchedProductList(QueryProductListDto queryProductListDto) {
        LaunchedProductListDto launchedProductListDto = productDomain.getLaunchedProductList(queryProductListDto);
        return launchedProductListDto;

    }

    @Override
    public ProductDetailDto getProductDetailInfo(QueryProductListDto queryProductListDto) {
        ProductDetailDto productDetailDto = productDomain.getProductDetailInfo(queryProductListDto);
        return productDetailDto;
    }

}
