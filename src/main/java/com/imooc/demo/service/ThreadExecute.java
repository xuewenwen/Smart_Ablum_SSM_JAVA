package com.imooc.demo.service;

import com.imooc.demo.service.impl.TagServiceImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public interface ThreadExecute {
    static final ThreadPoolExecutor JOB_EXECUTOR = new ThreadPoolExecutor(10,
            20,10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100000),new ThreadPoolExecutor.CallerRunsPolicy());
    static final Semaphore JOB_SEMAPHORE = new Semaphore(1);
    public void Execute(String path, Integer id);
}
