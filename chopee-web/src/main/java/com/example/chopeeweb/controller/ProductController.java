package com.example.chopeeweb.controller;

import com.example.chopeebiz.dto.*;
import com.example.chopeedao.po.Product;
import com.example.chopeedao.po.ProductDetailPhoto;
import com.example.chopeeservice.ProductService;
import com.example.chopeeweb.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


/**
 * 用户
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     *查询商品列表
     * @param queryProductListDto
     * @return
     */
    @RequestMapping(value ="/getList",method = RequestMethod.POST)
    public Result<Product> getProductList(@RequestBody QueryProductListDto queryProductListDto) {

        ProductListDto productListDto = productService.selectProductList(queryProductListDto);
        return Result.builder().data(productListDto,Result.SUCCESS,"").build();

    }

    /**
     *删除货品
     * @param
     * @return
     */
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public Result<Product> deleteProduct(@RequestBody QueryProductListDto queryProductListDto) {
        String productNum = queryProductListDto.getProductNum();
        productService.deleteProductByProductNum(productNum);
        return Result.builder().data(true, Result.SUCCESS,"").build();
    }

    /**
     *上下架货品
     * @param
     * @return
     */
    @RequestMapping(value ="/launch",method = RequestMethod.POST)
    public Result<Product> lanuchProduct(@RequestBody QueryProductListDto queryProductListDto) {
        productService.updateProductByProductNum(queryProductListDto);
        return Result.builder().data(true, Result.SUCCESS,"").build();

    }

    /**
     *新增或编辑商品
     * @param
     * @return
     */
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Result<Product> lanuchProduct(@RequestBody @Validated  ProductInsertDto productInsertDto) {
        productService.insertOrUpdateProduct(productInsertDto);
        return Result.builder().data(true, Result.SUCCESS,"").build();
    }

    /**
     * 获取商品列表（只返回已上架的商品）
     * @param
     * @return
     */
    @RequestMapping(value ="/getLaunchedProductList",method = RequestMethod.POST)
    public Result<LaunchedProductDto> getLaunchedProductList(@RequestBody QueryProductListDto queryProductListDto) {
        LaunchedProductListDto launchedProductListDto = productService.getLaunchedProductList(queryProductListDto);
        return Result.builder().data(launchedProductListDto, Result.SUCCESS,"").build();
    }

    /**
     * 获取商品详情信息
     * @param
     * @return
     */
    @RequestMapping(value ="/getProductDetailInfo",method = RequestMethod.POST)
    public Result<ProductDetailDto> getProductDetailInfo(@RequestBody QueryProductListDto queryProductListDto) {
        ProductDetailDto productDetailDto = productService.getProductDetailInfo(queryProductListDto);
        return Result.builder().data(productDetailDto, Result.SUCCESS,"").build();
    }

}
