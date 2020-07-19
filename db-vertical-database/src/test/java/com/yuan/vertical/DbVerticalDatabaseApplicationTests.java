package com.yuan.vertical;

import com.yuan.vertical.dao.MarketActivityMapper;
import com.yuan.vertical.dao.TdMsSmsMapper;
import com.yuan.vertical.entity.MarketActivity;
import com.yuan.vertical.entity.TdMsSms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbVerticalDatabaseApplicationTests {
    @Resource
    private MarketActivityMapper marketActivityMapper;
    @Resource
    private TdMsSmsMapper tdMsSmsMapper;

    @Test
    public void insetM2() {
        TdMsSms tdMsSms = new TdMsSms();
        tdMsSms.setCreateTime(new Date());
        tdMsSms.setPhone("2131");
        tdMsSms.setUserName("liNa");
        tdMsSmsMapper.insert(tdMsSms);
    }

    @Test
    public void insertM1(){
        MarketActivity marketActivity = new MarketActivity();
        marketActivity.setName("chen");
        marketActivity.setStartTime(new Date());
        marketActivityMapper.insert(marketActivity);
    }
}
