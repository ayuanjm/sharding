package com.yuan.dynamic;

import com.yuan.dynamic.dao.master.MarketActivityMapper;
import com.yuan.dynamic.dao.slave.TReadWriteMapper;
import com.yuan.dynamic.entity.MarketActivity;
import com.yuan.dynamic.entity.TReadWrite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yuanjm
 * @date 2020/8/4 3:31 下午
 */
@Service
public class Demo {
    @Resource
    private MarketActivityMapper marketActivityMapper;
    @Resource
    private TReadWriteMapper tReadWriteMapper;

    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
//        MarketActivity marketActivity = marketActivityMapper.selectByPrimaryKey(1L);
//        System.out.println(marketActivity);
//        TReadWrite tReadWrite = tReadWriteMapper.selectByPrimaryKey(1L);
//        System.out.println(tReadWrite);
//        marketActivityMapper.insert(new MarketActivity());
        tReadWriteMapper.insert(new TReadWrite());
        int a = 1/0;
    }
}
