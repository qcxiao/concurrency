package com.yaodao.concurrency._4.commonUnsafe.collection.safe;

import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Hashtable的key和value不能为null
 * @Author: yaodao
 * @Date: 2019/2/17 17:23
 */
@Slf4j
@ThreadSafe
public class HashTableTest {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static Map<Integer, Integer> map = new Hashtable<>();


    public static void main(String[] args) throws Exception {
        // 定义并初始化线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("map size:{}", map.size());
    }

    private static void add(int i) {
        map.put(i, i);
    }
}
