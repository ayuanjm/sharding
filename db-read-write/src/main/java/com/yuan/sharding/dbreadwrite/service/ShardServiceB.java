package com.yuan.sharding.dbreadwrite.service;

import com.yuan.sharding.dbreadwrite.entity.TReadWrite;

/**
 * @author yuanjm
 * @date 2020/7/20 9:23 上午
 */
public interface ShardServiceB {
    void insert(TReadWrite tReadWrite);
}
