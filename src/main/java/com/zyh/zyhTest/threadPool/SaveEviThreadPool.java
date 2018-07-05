package com.zyh.zyhTest.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * Created by YatHong on 2018/7/4/0004.
 */
@Slf4j
public class SaveEviThreadPool extends ThreadPoolExecutor {

    public SaveEviThreadPool(int corePoolSize, int maxPoolSize,long keepAliveTime, int capacity) {
        super(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<>(capacity), new CallerRunsPolicy());
    }

    @Override
    public void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        this.statistics("执行前");
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        this.statistics("执行后");
    }

    @Override
    public void terminated() {
        super.terminated();
    }


    private void statistics(String str){
        BlockingQueue<Runnable> queue = this.getQueue();
        log.info("【{}】当前活动线程/已启动线程/线程最大容量:{}/{}/{},队列容量:{}/{},完成任务数量:{}/{}", str,
                this.getActiveCount(), this.getPoolSize(), this.getMaximumPoolSize(),
                queue.size(), queue.remainingCapacity()+queue.size(),
                this.getCompletedTaskCount(), this.getTaskCount());
    }
}
