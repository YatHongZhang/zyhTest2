package com.zyh.zyhTest;

import com.zyh.zyhTest.threadPool.MyThread;
import com.zyh.zyhTest.threadPool.SaveEviThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by YatHong on 2018/6/28/0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-test.xml"})
@Slf4j
public class BaseTest {
    @Autowired
    @Qualifier("saveEviThreadPool")
    private SaveEviThreadPool saveEviThreadPool;
    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    public void testSaveEviThreadPool() throws Exception{

        for(int i=0 ;i<50;i++){
            saveEviThreadPool.execute(new MyThread());
        }

        for(int i=0 ;i<10;i++){
            Thread.sleep(200);
        }

        log.info("休息一会");
        Thread.sleep(3000);

        for(int i=0 ;i<50;i++){
            saveEviThreadPool.execute(new MyThread());
        }

        Thread.sleep(3000);
        log.info("over~!~!~!~!");
    }


    @Test
    public void testThreadPoolTaskExecutor() throws Exception{
        LinkedBlockingQueue queue = (LinkedBlockingQueue)executor.getThreadPoolExecutor().getQueue();

        log.info("执行前,线程活跃数量/当前数量/最大数量:{}/{}/{},队列大小:{}/{}", executor.getActiveCount(), executor.getPoolSize(), executor.getMaxPoolSize(),queue.size(),queue.remainingCapacity()+queue.size());
        for(int i=0 ;i<50;i++){
            executor.execute(new MyThread());
            log.info("开始执行,线程活跃数量/当前数量/最大数量:{}/{}/{},队列大小:{}/{}", executor.getActiveCount(), executor.getPoolSize(), executor.getMaxPoolSize(),queue.size(),queue.remainingCapacity()+queue.size());
        }

        for(int i=0 ;i<10;i++){
            log.info("执行完毕,线程活跃数量/当前数量/最大数量:{}/{}/{},队列大小:{}/{}", executor.getActiveCount(), executor.getPoolSize(), executor.getMaxPoolSize(),queue.size(),queue.remainingCapacity()+queue.size());
            Thread.sleep(200);
        }

        log.info("休息一会");
        Thread.sleep(3000);

        for(int i=0 ;i<50;i++){
            executor.execute(new MyThread());
            log.info("二次执行,线程活跃数量/当前数量/最大数量:{}/{}/{},队列大小:{}/{}", executor.getActiveCount(), executor.getPoolSize(), executor.getMaxPoolSize(),queue.size(),queue.remainingCapacity()+queue.size());
        }

        Thread.sleep(3000);
        log.info("over");
    }

    private void printLog(String str){
        //log.info(str + ",线程活跃数量/当前数量/最大数量:{}/{}/{},队列大小:{}/{}", executor.getActiveCount(), executor.getPoolSize(), executor.getMaxPoolSize(),queue.size(),queue.remainingCapacity()+queue.size());
    }
}
