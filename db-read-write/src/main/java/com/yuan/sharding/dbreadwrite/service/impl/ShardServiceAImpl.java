package com.yuan.sharding.dbreadwrite.service.impl;

import com.yuan.sharding.dbreadwrite.dao.TReadWriteMapper;
import com.yuan.sharding.dbreadwrite.entity.TReadWrite;
import com.yuan.sharding.dbreadwrite.service.ShardServiceA;
import com.yuan.sharding.dbreadwrite.service.ShardServiceB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yuanjm
 * @date 2020/7/20 9:23 上午
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ShardServiceAImpl implements ShardServiceA {
    @Resource
    private TReadWriteMapper tReadWriteMapper;
    @Resource
    private ShardServiceB serviceB;

    @Override
    public void insert(TReadWrite tReadWrite) {
        //先获取slave数据库连接
        tReadWriteMapper.selectByPrimaryKey(5L);
        //再获取master数据库连接
        tReadWriteMapper.insert(tReadWrite);
        //再获取slave数据库连接
        tReadWriteMapper.selectByPrimaryKey(5L);

        try {
            serviceB.insert(tReadWrite);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
