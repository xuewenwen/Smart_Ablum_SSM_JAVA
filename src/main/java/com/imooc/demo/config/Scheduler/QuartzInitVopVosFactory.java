package com.imooc.demo.config.Scheduler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 初始化运营信息接口调用
 * @author wxy
 * @date 2018年6月4日 下午5:27:12
 */
@DisallowConcurrentExecution
public class QuartzInitVopVosFactory implements Job {

//    @Autowired
//    private RedisTemplate<String, ?> redisTemplate;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //这里写job代码，就是这个任务，具体要实现什么，就在这里写
        //Shift  jobBean = (Shift) jobExecutionContext.getMergedJobDataMap().get("job");
        //上面这句比较坑,必须用getMergedJobDataMap，不然获取的是一个list<map>对象。不好解析，
        //所有的参数以及其他信息都在JobExecutionContext
        //顺带提一句，如果你没有JobFactory 这个类，在这里是没办法注入任何类的。
        //shift是实体类，


    }
}
