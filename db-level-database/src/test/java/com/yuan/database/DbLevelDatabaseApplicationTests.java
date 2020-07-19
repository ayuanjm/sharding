package com.yuan.database;

import com.yuan.database.dao.MarketActivityMapper;
import com.yuan.database.dao.TdMsSmsMapper;
import com.yuan.database.entity.TdMsSms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbLevelDatabaseApplicationTests {
    @Resource
    private TdMsSmsMapper tdMsSmsMapper;


    @Resource
    private MarketActivityMapper marketActivityMapper;

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            TdMsSms tdMsSms = new TdMsSms();
            tdMsSms.setUserName("yuan");
            tdMsSms.setPhone("1231");
            tdMsSms.setCreateTime(new Date());
            tdMsSmsMapper.insert(tdMsSms);
        }

    }

    @Test
    public void selectNoSharding() {
        marketActivityMapper.selectByPrimaryKey(1L);
    }


}
