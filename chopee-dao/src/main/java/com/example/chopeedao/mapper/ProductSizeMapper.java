package com.example.chopeedao.mapper;

import com.example.chopeedao.po.ProductSize;
import com.example.chopeedao.po.ProductSizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductSize record);

    int insertSelective(ProductSize record);

    List<ProductSize> selectByExample(ProductSizeExample example);

    ProductSize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSize record, @Param("example") ProductSizeExample example);

    int updateByExample(@Param("record") ProductSize record, @Param("example") ProductSizeExample example);

    int updateByPrimaryKeySelective(ProductSize record);

    int updateByPrimaryKey(ProductSize record);
}