package com.imooc.demo.job;

import com.imooc.demo.service.PictureService;
import com.imooc.demo.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class RecycleScheduled {
    @Autowired
    private RecycleService recycleService;
    @Autowired
    private PictureService pictureService;
    //每天中午12点执行
    //删除回收站中所有大于30天的照片
    @Scheduled(cron = "0 0 12 * * ?")
    public void Delete30day(){
        recycleService.deletePic30day();
    }

    //检查用户的照片数量与容量是否与数据库中数据相符合
    //0点判断
    @Scheduled(cron = "0 * 0 * * ?")
    public void checkNumAndSize() throws Exception {
        pictureService.updateMessageByJob();
    }

}
