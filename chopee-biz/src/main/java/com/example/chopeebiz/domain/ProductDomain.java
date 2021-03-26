package com.example.chopeebiz.domain;


import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.Product;

public interface ProductDomain {

    /**
     * 根据查询条件获取商品列表
     * @param queryProductListDto
     * @return
     */
    ProductListDto SelectProductList(QueryProductListDto queryProductListDto);

    /**
     * 根据商品编号删除商品
     */
    void deleteProductByProductNum(String productNum);

    /**
     * 根据商品编号上架商品
     */
    void updateProductByProductNum(String productNum, Product product);

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
