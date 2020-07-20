package com.yuan.sharding.dbreadwrite;

import com.yuan.sharding.dbreadwrite.dao.MarketActivityMapper;
import com.yuan.sharding.dbreadwrite.dao.TReadWriteMapper;
import com.yuan.sharding.dbreadwrite.entity.TReadWrite;
import com.yuan.sharding.dbreadwrite.service.ShardServiceA;
import com.yuan.sharding.dbreadwrite.service.ShardServiceB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbReadWriteApplicationTests {
    @Autowired
    private ApplicationContext ioc;

    @Resource
    private TReadWriteMapper tReadWriteMapper;

    @Resource
    private MarketActivityMapper marketActivityMapper;

    @Resource
    private ShardServiceA serviceA;

    @Autowired
    private ShardServiceB serviceB;

//    @Test
//    public void insert() {
//        TReadWrite tReadWrite = new TReadWrite();
//        tReadWrite.setId(1L);
//        tReadWrite.setName("write");
//        tReadWrite.setType("master");
//        tReadWriteMapper.insert(tReadWrite);
//    }
//
//    @Test
//    public void select() {
//        tReadWriteMapper.selectByPrimaryKey(1L);
//    }
//
//    @Test
//    public void selectNoShardingTables() {
//        marketActivityMapper.selectByPrimaryKey(1L);
//    }

    /**
     * 经过测试，读写分离事务和spring一样，不受读写分离影响，内部封装兼容spring事务
     */
    @Test
    public void transactional() {
        TReadWrite tReadWrite = new TReadWrite();
        tReadWrite.setId(6L);
        tReadWrite.setName("write");
        tReadWrite.setType("master");
        serviceA.insert(tReadWrite);
//        serviceB.insert(tReadWrite);
    }
}
