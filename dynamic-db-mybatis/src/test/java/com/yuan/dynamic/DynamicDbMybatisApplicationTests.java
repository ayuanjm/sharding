package com.yuan.dynamic;

import com.yuan.dynamic.dao.master.MarketActivityMapper;
import com.yuan.dynamic.dao.slave.TReadWriteMapper;
import com.yuan.dynamic.entity.MarketActivity;
import com.yuan.dynamic.entity.TReadWrite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDbMybatisApplicationTests {
    @Resource
    private TReadWriteMapper tReadWriteMapper;

    @Resource
    private MarketActivityMapper marketActivityMapper;

    @Resource
    private Demo demo;

    @Test
    public void selectSlave() {
        TReadWrite tReadWrite = tReadWriteMapper.selectByPrimaryKey(1L);
        System.out.println(tReadWrite);
    }

    @Test
    public void selectMaster() {
        MarketActivity marketActivity = marketActivityMapper.selectByPrimaryKey(1L);
        System.out.println(marketActivity);
    }

    @Test
    public void testTransaction() {
        demo.testTransactional();
    }

}