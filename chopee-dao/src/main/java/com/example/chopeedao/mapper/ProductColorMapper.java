package com.example.chopeedao.mapper;

import com.example.chopeedao.po.ProductColor;
import com.example.chopeedao.po.ProductColorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductColorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductColor record);

    int insertSelective(ProductColor record);

    List<ProductColor> selectByExample(ProductColorExample example);

    ProductColor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductColor record, @Param("example") ProductColorExample example);

    int updateByExample(@Param("record") ProductColor record, @Param("example") ProductColorExample example);

    int updateByPrimaryKeySelective(ProductColor record);

    int updateByPrimaryKey(ProductColor record);
}