package com.yuan.sharding.dbreadwrite.service.impl;

import com.yuan.sharding.dbreadwrite.dao.TReadWriteMapper;
import com.yuan.sharding.dbreadwrite.entity.TReadWrite;
import com.yuan.sharding.dbreadwrite.service.ShardServiceB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yuanjm
 * @date 2020/7/20 9:23 上午
 */
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
@Service
public class ShardServiceBImpl implements ShardServiceB {
    @Resource
    private TReadWriteMapper tReadWriteMapper;

    @Override
    public void insert(TReadWrite tReadWrite) {
        System.out.println(1);
        tReadWrite.setId(1L);
        tReadWriteMapper.insert(tReadWrite);
        //测试sharding-jdbc读写分离事务
        int a = 1 / 0;

    }
}
