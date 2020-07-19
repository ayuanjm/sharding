package com.yuan.sharding.dao;

import com.yuan.sharding.entity.TdMsSms;

public interface TdMsSmsMapper {
    int deleteByPrimaryKey(Long id);

    /**
     * insert时不需要带id，id是sharding jdbc雪花算法自动生成的，不需要我们写id,因此sql中也不能有id，否则会报异常
     * 除非你不使用sharding-jdbc内嵌的雪花算法，自己生成分布式id，这样就需要在sql中写id，传参也要传id。
     * @param record
     * @return
     */
    int insert(TdMsSms record);

    int insertSelective(TdMsSms record);

    TdMsSms selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TdMsSms record);

    int updateByPrimaryKey(TdMsSms record);
}