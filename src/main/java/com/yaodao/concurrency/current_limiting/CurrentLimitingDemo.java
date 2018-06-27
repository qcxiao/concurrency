package com.yaodao.concurrency.current_limiting;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 限流
 */
@Slf4j
public class CurrentLimitingDemo {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Date startDate = new Date();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    new DubboService().process();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        Date endDate = new Date();
        long ms = endDate.getTime() - startDate.getTime();
        log.info("执行时间：{}", ms);
    }
}

@Slf4j
class DubboService {
    private final Semaphore permit = new Semaphore(100, true);

    public void process() {
        try {
            permit.acquire();            //业务逻辑处理
            //log.info("正在处理");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            permit.release();
        }
    }
}
