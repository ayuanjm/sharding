package com.yuan.vertical.dao;

import com.yuan.vertical.entity.TCommon;

public interface TCommonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCommon record);

    int insertSelective(TCommon record);

    TCommon selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCommon record);

    int updateByPrimaryKey(TCommon record);
}