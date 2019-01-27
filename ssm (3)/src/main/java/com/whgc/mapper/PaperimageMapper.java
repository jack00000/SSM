package com.whgc.mapper;

import com.whgc.pojo.Paperimage;
import com.whgc.pojo.PaperimageExample;
import java.util.List;

public interface PaperimageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paperimage record);

    int insertSelective(Paperimage record);

    List<Paperimage> selectByExample(PaperimageExample example);

    Paperimage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paperimage record);

    int updateByPrimaryKey(Paperimage record);
}