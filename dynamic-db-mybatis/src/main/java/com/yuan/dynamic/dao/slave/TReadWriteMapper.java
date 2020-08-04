package com.yuan.dynamic.dao.slave;

import com.yuan.dynamic.entity.TReadWrite;

public interface TReadWriteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TReadWrite record);

    int insertSelective(TReadWrite record);

    TReadWrite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TReadWrite record);

    int updateByPrimaryKey(TReadWrite record);
}