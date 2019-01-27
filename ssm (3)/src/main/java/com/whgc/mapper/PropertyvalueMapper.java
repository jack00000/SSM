package com.whgc.mapper;

import com.whgc.pojo.Propertyvalue;
import com.whgc.pojo.PropertyvalueExample;
import java.util.List;

public interface PropertyvalueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Propertyvalue record);

    int insertSelective(Propertyvalue record);

    List<Propertyvalue> selectByExample(PropertyvalueExample example);

    Propertyvalue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Propertyvalue record);

    int updateByPrimaryKey(Propertyvalue record);
}