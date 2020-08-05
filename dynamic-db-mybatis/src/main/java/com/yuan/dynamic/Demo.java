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

    /**
     * clusterTransactionManager
     * 不同sqlSessionFactory在同一个事务内，只有对应和事务管理器相同数据源的sqlSessionFactory才受事务控制。
     */
    @Transactional(rollbackFor = Exception.class, transactionManager = "masterTransactionManager")
    public void testTransactional() {
        /**
         * 没有添加明确指定事务管理器时，默认使用masterTransactionManager；
         * 当执行该方法时根据事务管理器创建事务，将数据源DataSource(master)和connectionHolder与当前线程绑定
         * 执行marketActivityMapper方法时去获取数据库连接，通过masterSqlSessionFactory绑定的DataSource(master)为key去当前线程
         * 获取数据库连接，发现在ThreadLocal中存在对应的数据库连接，以该数据库连接执行sql，该connection为非自动提交autoCommit = false。
         * 执行tReadWriteMapper方法时去获取数据库连接，通过clusterSqlSessionFactory绑定的DataSource(slave)为key去当前线程中
         * 获取数据库连接，发现在ThreadLocal中不存在DataSource(slave)为key的value值，所以会重DataSource(slave)获取一个新的数据库连接，
         * 获取的新的数据库连接没有设置非自动提交，是自动提交的autoCommit = true，所以tReadWriteMapper不受masterTransactionManager事务管理，
         * 因为不是同一个数据库连接，出现异常时会回滚当前事务对应的sqlSessionFactory的mapper，因为他们拿的是同一个数据库连接，该连接在创建事务时设置为了非自动提交，
         * 但是不会回滚和当前事务不同DataSource，也就是不同sqlSessionFactory的mapper，因为他们拿的数据库连接是新的连接，与事务无关，自动提交。
         */
//        MarketActivity marketActivity = marketActivityMapper.selectByPrimaryKey(1L);
//        System.out.println(marketActivity);
//        TReadWrite tReadWrite = tReadWriteMapper.selectByPrimaryKey(1L);
//        System.out.println(tReadWrite);
        marketActivityMapper.insert(new MarketActivity());
        tReadWriteMapper.insert(new TReadWrite());
        int a = 1 / 0;
    }
}
