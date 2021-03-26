package com.example.chopeedao.mapper;

import com.example.chopeedao.po.Dict_Data;
import com.example.chopeedao.po.Dict_DataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Dict_DataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dict_Data record);

    int insertSelective(Dict_Data record);

    List<Dict_Data> selectByExampleWithBLOBs(Dict_DataExample example);

    List<Dict_Data> selectByExample(Dict_DataExample example);

    Dict_Data selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dict_Data record, @Param("example") Dict_DataExample example);

    int updateByExampleWithBLOBs(@Param("record") Dict_Data record, @Param("example") Dict_DataExample example);

    int updateByExample(@Param("record") Dict_Data record, @Param("example") Dict_DataExample example);

    int updateByPrimaryKeySelective(Dict_Data record);

    int updateByPrimaryKeyWithBLOBs(Dict_Data record);

    int updateByPrimaryKey(Dict_Data record);
}