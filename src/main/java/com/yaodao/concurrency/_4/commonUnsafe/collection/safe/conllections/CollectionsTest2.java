package com.yaodao.concurrency._4.commonUnsafe.collection.safe.conllections;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: yaodao
 * @Date: 2019/2/17 18:05
 */
@Slf4j
@ThreadSafe
public class CollectionsTest2 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());


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
        log.info("set size:{}", set.size());
    }

    private static void add(int i) {
        set.add(i);
    }
}