package com.yuan.sharding;

import com.yuan.sharding.dao.TdMsSmsMapper;
import com.yuan.sharding.entity.TdMsSms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbLevelTableApplicationTests {
    @Resource
    private TdMsSmsMapper tdMsSmsMapper;

    @Test
    public void contextLoads() {
        for (int i =0;i<100;i++){
            TdMsSms tdMsSms = new TdMsSms();
            tdMsSms.setCreateTime(new Date());
            tdMsSms.setPhone("12");
            tdMsSms.setUserName("yu");
            tdMsSmsMapper.insert(tdMsSms);
        }

    }

}
