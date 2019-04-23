package com.imooc.demo.job;

import com.imooc.demo.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RecycleScheduled {
    @Autowired
    private RecycleService recycleService;
    //每天中午12点执行
    @Scheduled(cron = "0 0 12 * * ?")
    public void Delete30day(){
        recycleService.deletePic30day();
    }
}
