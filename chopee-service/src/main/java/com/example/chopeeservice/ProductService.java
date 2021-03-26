package com.example.chopeeservice;

import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.Product;

public interface ProductService {

    /**
     * 获取商品列表
     */
    ProductListDto selectProductList(QueryProductListDto queryProductListDto);

    /**
     * 根据商品编号删除商品
     */
    void deleteProductByProductNum(String productNum);

    /**
     * 根据商品编号上下架商品
     */
    void updateProductByProductNum(QueryProductListDto queryProductListDto);

    /**
     * 新增或修改商品
     */
    void insertOrUpdateProduct(ProductInsertDto productInsertDto);

    /**
     * 获取商品列表（只返回已上架的商品） addTime降序
     */
    LaunchedProductListDto getLaunchedProductList(QueryProductListDto queryProductListDto);

    /**
     * 获取商品详情信息
     */
    ProductDetailDto getProductDetailInfo(QueryProductListDto queryProductListDto);
}
