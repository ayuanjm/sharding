package com.yuan.sharding;

import com.yuan.sharding.dao.MarketActivityMapper;
import com.yuan.sharding.dao.TdMsSmsMapper;
import com.yuan.sharding.dao.user.UserTdMsSmsMapper;
import com.yuan.sharding.entity.MarketActivity;
import com.yuan.sharding.entity.TdMsSms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbLevelTableApplicationTests {
    @Resource
    private TdMsSmsMapper tdMsSmsMapper;

    @Resource
    private UserTdMsSmsMapper userTdMsSmsMapper;

    @Resource
    private MarketActivityMapper marketActivityMapper;

    @Test
    public void insert() {
        TdMsSms tdMsSms = new TdMsSms();
        tdMsSms.setUserName("yuan");
        tdMsSms.setPhone("1231");
        tdMsSms.setCreateTime(new Date());
        tdMsSmsMapper.insert(tdMsSms);
    }

    @Test
    public void selectByPrimaryKey() {
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(491643184279977984L);
        longs.add(491641359782903809L);
        userTdMsSmsMapper.selectByPrimaryKey(longs);
    }

    @Test
    public void selectByName() {
        userTdMsSmsMapper.selectByName("yuan");
    }

    @Test
    public void selectNoSharding() {
        marketActivityMapper.selectByPrimaryKey(1L);
    }

}
