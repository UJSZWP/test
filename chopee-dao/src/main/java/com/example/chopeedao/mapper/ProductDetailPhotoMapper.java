package com.example.chopeedao.mapper;

import com.example.chopeedao.po.ProductDetailPhoto;
import com.example.chopeedao.po.ProductDetailPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDetailPhotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductDetailPhoto record);

    int insertSelective(ProductDetailPhoto record);

    List<ProductDetailPhoto> selectByExample(ProductDetailPhotoExample example);

    ProductDetailPhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductDetailPhoto record, @Param("example") ProductDetailPhotoExample example);

    int updateByExample(@Param("record") ProductDetailPhoto record, @Param("example") ProductDetailPhotoExample example);

    int updateByPrimaryKeySelective(ProductDetailPhoto record);

    int updateByPrimaryKey(ProductDetailPhoto record);
}