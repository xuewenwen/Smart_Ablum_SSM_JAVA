package com.imooc.demo.service.impl;

import com.imooc.demo.service.TagService;
import com.imooc.demo.service.ThreadExecute;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Service
public class ThreadExecuteImpl implements ThreadExecute {
    private static final ThreadPoolExecutor JOB_EXECUTOR = new ThreadPoolExecutor(10,
            20,10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100000),new ThreadPoolExecutor.CallerRunsPolicy());
    private static final Semaphore JOB_SEMAPHORE = new Semaphore(1);
    public void Execute(String path, Integer id){
        final String p =path;
        final Integer i = id;
        JOB_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //获得许可
                    JOB_SEMAPHORE.acquire();
                    TagService tagService = new TagServiceImpl();
                    tagService.Ai(p,i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //访问完，释放
                    JOB_SEMAPHORE.release();
                }
            }
        });
    }
}
