package com.example.chopeebiz.domain.Impl;


import com.example.chopeebiz.domain.ProductDomain;
import com.example.chopeebiz.domain.util.IdUtil;
import com.example.chopeebiz.dto.*;
import com.example.chopeebiz.enums.ProductStatusEnum;
import com.example.chopeedao.mapper.ProductColorMapper;
import com.example.chopeedao.mapper.ProductDetailPhotoMapper;
import com.example.chopeedao.mapper.ProductMapper;
import com.example.chopeedao.mapper.ProductSizeMapper;
import com.example.chopeedao.po.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.chopeebiz.enums.ProductCategoryEnum;

import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component

public class ProductDomainImpl implements ProductDomain {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductColorMapper productColorMapper;

    @Autowired
    private ProductSizeMapper productSizeMapper;

    @Autowired
    private ProductDetailPhotoMapper productDetailPhotoMapper;

    @Override
    public ProductListDto SelectProductList(QueryProductListDto queryProductListDto) {
        ProductListDto productListDto = new ProductListDto();
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();

        criteria.andIsDeleteEqualTo("0");
        if(StringUtil.isNotEmpty(queryProductListDto.getProductNum())) {
            criteria.andProductNumEqualTo(queryProductListDto.getProductNum());
        }
        if(null != queryProductListDto.getProductCategoryId()) {
            criteria.andProductCategoryIdEqualTo(queryProductListDto.getProductCategoryId());
        }
        if(null != queryProductListDto.getProductStatusId() ) {
            criteria.andProductStatusIdEqualTo(queryProductListDto.getProductStatusId());
        }

        // 分页查询
        PageHelper.startPage(queryProductListDto.getPage().getPageNo(), queryProductListDto.getPage().getPageSize());
        List<Product> productList = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        // 取出页数
        Page page = queryProductListDto.getPage();
        page.setTotalCount((int) pageInfo.getTotal());
        page.setTotal(pageInfo.getPages());
        productListDto.setPage(page);
        productListDto.setProductList(productList);
        return productListDto;
    }

    @Override
    public void deleteProductByProductNum(String productNum) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductNumEqualTo(productNum)
                .andIsDeleteEqualTo("0");
        Product product = new Product();
        product.setIsDelete("1");
        productMapper.updateByExampleSelective(product,example);
    }

    @Override
    public void updateProductByProductNum(String productNum, Product product) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductNumEqualTo(productNum)
                .andIsDeleteEqualTo("0");
        productMapper.updateByExampleSelective(product,example);
    }

    @Override
    public void insertOrUpdateProduct(ProductInsertDto productInsertDto) {
        Product product = new Product();
        product.setPhotoUrl(productInsertDto.getCoverPhotoUrl());
        BeanUtils.copyProperties(productInsertDto, product);

        // 商品颜色
        List<ProductColor> productColorList = new ArrayList<>();
        if(null != productInsertDto.getColorList()) {
            List<String> colorList = Arrays.asList(productInsertDto.getColorList());
            productColorList = colorList.stream().map(c -> {
                ProductColor productColor = new ProductColor();
                productColor.setColor(c);
                return productColor;
            }).collect(Collectors.toList());
        }

        //商品尺寸
        List<ProductSize> productSizeList = new ArrayList<>();
        if(null != productInsertDto.getSizeList()) {
            List<String> sizeList = Arrays.asList(productInsertDto.getSizeList());
            productSizeList = sizeList.stream().map(s -> {
                ProductSize productSize = new ProductSize();
                productSize.setSize(s);
                return productSize;
            }).collect(Collectors.toList());
        }

        //商品 详情图
        List<ProductDetailPhoto> productDetailPhotoList = new ArrayList<>();
        if(null != productInsertDto.getDetailPhotoUrl()) {
            List<String> detailPhotoUrlList = Arrays.asList(productInsertDto.getDetailPhotoUrl());
            productDetailPhotoList = detailPhotoUrlList.stream().map(s -> {
                ProductDetailPhoto productDetailPhoto = new ProductDetailPhoto();
                productDetailPhoto.setDetailPhotoUrl(s);
                return productDetailPhoto;
            }).collect(Collectors.toList());
        }

        if(StringUtil.isNotEmpty(product.getProductCategoryId())) {
            ProductCategoryEnum productCategoryEnum = ProductCategoryEnum.fromCode(product.getProductCategoryId());
            if(null != productCategoryEnum) {
                product.setProductCategoryName(productCategoryEnum.getName());
            }
        }

        String productNum = null;
        // 如果商品编码存在，则更新,否则就新增
        if(StringUtil.isNotEmpty(product.getProductNum())) {
            productNum = product.getProductNum();
            ProductExample example = new ProductExample();
            example.createCriteria().andProductNumEqualTo(productNum)
                    .andIsDeleteEqualTo("0");
            productMapper.updateByExampleSelective(product,example);
        } else {
            productNum = IdUtil.getUUIDInOrderId().toString();
            product.setProductNum(productNum);
            productMapper.insertSelective(product);
        }

        //颜色、尺寸、详情图，先删除再添加
        if(!CollectionUtils.isEmpty(productColorList)) {
            ProductColorExample colorExample = new ProductColorExample();
            colorExample.createCriteria().andProductNumEqualTo(productNum)
                    .andIsDeleteEqualTo("0");
            ProductColor productColor = new ProductColor();
            productColor.setIsDelete("1");
            productColorMapper.updateByExampleSelective(productColor, colorExample);
            String finalProductNum = productNum;
            productColorList.stream().forEach(color -> {
                color.setProductNum(finalProductNum);
                productColorMapper.insertSelective(color);
            });
        }

        if(!CollectionUtils.isEmpty(productSizeList)) {
            ProductSizeExample sizeExample = new ProductSizeExample();
            sizeExample.createCriteria().andProductNumEqualTo(productNum)
                    .andIsDeleteEqualTo("0");
            ProductSize productSize = new ProductSize();
            productSize.setIsDelete("1");
            productSizeMapper.updateByExampleSelective(productSize, sizeExample);
            String finalProductNum1 = productNum;
            productSizeList.stream().forEach(size -> {
                size.setProductNum(finalProductNum1);
                productSizeMapper.insertSelective(size);
            });
        }

        if(!CollectionUtils.isEmpty(productDetailPhotoList)) {
            ProductDetailPhotoExample productDetailPhotoExample = new ProductDetailPhotoExample();
            productDetailPhotoExample.createCriteria().andProductNumEqualTo(productNum)
                    .andIsDeleteEqualTo("0");
            ProductDetailPhoto productDetailPhoto = new ProductDetailPhoto();
            productDetailPhoto.setIsDelete("1");
            productDetailPhotoMapper.updateByExampleSelective(productDetailPhoto, productDetailPhotoExample);
            String finalProductNum2 = productNum;
            productDetailPhotoList.stream().forEach(photo -> {
                photo.setProductNum(finalProductNum2);
                productDetailPhotoMapper.insertSelective(photo);
            });
        }
    }

    @Override
    public LaunchedProductListDto getLaunchedProductList(QueryProductListDto queryProductListDto) {
        LaunchedProductListDto launchedProductListDto = new LaunchedProductListDto();
        ProductExample example = new ProductExample();
        example.createCriteria().andIsDeleteEqualTo("0")
                .andProductStatusIdEqualTo(ProductStatusEnum.PUT_ON_SHELVES.getCode());
        example.setOrderByClause("addTime Desc");

        // 分页查询
        PageHelper.startPage(queryProductListDto.getPage().getPageNo(), queryProductListDto.getPage().getPageSize());
        List<Product> productList = productMapper.selectByExample(example);
        List<LaunchedProductDto> launchedProductDtoList = productList.stream().map(p -> {
            LaunchedProductDto launchedProductDto = new LaunchedProductDto();
            BeanUtils.copyProperties(p, launchedProductDto);
            return launchedProductDto;
        }).collect(Collectors.toList());
        PageInfo<LaunchedProductDto> pageInfo = new PageInfo<LaunchedProductDto>(launchedProductDtoList);
        // 取出页数
        Page page = queryProductListDto.getPage();
        page.setTotalCount((int) pageInfo.getTotal());
        page.setTotal(pageInfo.getPages());
        launchedProductListDto.setPage(page);
        launchedProductListDto.setLaunchedProductDtoList(launchedProductDtoList);
        return launchedProductListDto;
    }

    @Override
    public ProductDetailDto getProductDetailInfo(QueryProductListDto queryProductListDto) {
        ProductDetailDto productDetailDto = new ProductDetailDto();
        if(StringUtil.isEmpty(queryProductListDto.getProductNum())) {
            return null;
        }
        ProductExample example = new ProductExample();
        example.createCriteria().andIsDeleteEqualTo("0")
                .andProductNumEqualTo(queryProductListDto.getProductNum());
        List<Product> productList = productMapper.selectByExample(example);

        if(CollectionUtils.isEmpty(productList)) {
            return null;
        }
        Product product = productList.get(0);
        BeanUtils.copyProperties(product, productDetailDto);
        productDetailDto.setCoverPhotoUrl(product.getPhotoUrl());

        ProductSizeExample sizeExample = new ProductSizeExample();
        sizeExample.createCriteria().andProductNumEqualTo(queryProductListDto.getProductNum())
                .andIsDeleteEqualTo("0");
        List<ProductSize> productSizeList = productSizeMapper.selectByExample(sizeExample);
        List<String> sizeList = productSizeList.stream().map(s -> {
            return s.getSize();
        }).collect(Collectors.toList());
        String[] sizeStrs = sizeList.toArray(new String[sizeList.size()]);
        productDetailDto.setSizeList(sizeStrs);

        ProductColorExample colorExample = new ProductColorExample();
        colorExample.createCriteria().andProductNumEqualTo(queryProductListDto.getProductNum())
                .andIsDeleteEqualTo("0");
        List<ProductColor> productColorList = productColorMapper.selectByExample(colorExample);
        List<String> colorList = productColorList.stream().map(s -> {
            return s.getColor();
        }).collect(Collectors.toList());
        String[] colorStrs = colorList.toArray(new String[colorList.size()]);
        productDetailDto.setColorList(colorStrs);

        ProductDetailPhotoExample photoExample = new ProductDetailPhotoExample();
        photoExample.createCriteria().andProductNumEqualTo(queryProductListDto.getProductNum())
                .andIsDeleteEqualTo("0");
        List<ProductDetailPhoto> productDetailPhotoList = productDetailPhotoMapper.selectByExample(photoExample);
        List<String> photoList = productDetailPhotoList.stream().map(s -> {
            return s.getDetailPhotoUrl();
        }).collect(Collectors.toList());
        String[] photoStrs = photoList.toArray(new String[photoList.size()]);
        productDetailDto.setDetailPhotoUrl(photoStrs);

        return productDetailDto;
    }

}
