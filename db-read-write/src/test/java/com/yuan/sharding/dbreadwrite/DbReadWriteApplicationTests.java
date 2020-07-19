package com.yuan.sharding.dbreadwrite;

import com.yuan.sharding.dbreadwrite.dao.MarketActivityMapper;
import com.yuan.sharding.dbreadwrite.dao.TReadWriteMapper;
import com.yuan.sharding.dbreadwrite.entity.TReadWrite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbReadWriteApplicationTests {
    @Resource
    private TReadWriteMapper tReadWriteMapper;

    @Resource
    private MarketActivityMapper marketActivityMapper;

    @Test
    public void insert() {
        TReadWrite tReadWrite = new TReadWrite();
        tReadWrite.setId(1L);
        tReadWrite.setName("write");
        tReadWrite.setType("master");
        tReadWriteMapper.insert(tReadWrite);
    }

    @Test
    public void select() {
        tReadWriteMapper.selectByPrimaryKey(1L);
    }

    @Test
    public void selectNoShardingTables(){
        marketActivityMapper.selectByPrimaryKey(1L);
    }

}
