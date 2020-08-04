package com.yuan.vertical.dao;

import com.yuan.vertical.entity.TdMsSms;

public interface TdMsSmsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TdMsSms record);

    int insertSelective(TdMsSms record);

    TdMsSms selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TdMsSms record);

    int updateByPrimaryKey(TdMsSms record);
}