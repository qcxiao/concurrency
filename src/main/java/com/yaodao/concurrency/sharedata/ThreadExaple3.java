package com.yaodao.concurrency.sharedata;

import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这就是利用了CAS(Compare And Swap)机制
 * CAS机制是Atomic系列类和Lock系列类的底层实现
 * <p>
 * CAS机制当中使用了3个基本操作数：内存地址V，旧的预期值A，要修改的新值B。
 * 更新一个变量的时候，只有当变量的预期值A和内存地址V当中的实际值相同时，才会将内存地址V对应的值修改为B。
 * <p>
 * 从思想上来说，Synchronized属于悲观锁，悲观地认为程序中的并发情况严重，所以严防死守。
 * CAS属于乐观锁，乐观地认为程序中的并发情况不那么严重，所以让线程不断去尝试更新。
 * <p>
 * CAS的缺点：
 * 1.CPU开销较大
 * 在并发量比较高的情况下，如果许多线程反复尝试更新某一个变量，却又一直更新不成功，循环往复，会给CPU带来很大的压力。
 * 2.不能保证代码块的原子性
 * CAS机制所保证的只是一个变量的原子性操作，而不能保证整个代码块的原子性。
 * 比如需要保证3个变量共同进行原子性的更新，就不得不使用Synchronized了。
 * 3.ABA问题
 * 这是CAS机制最大的问题所在。
 * <p>
 * 1. Java语言CAS底层如何实现？
 * 利用unsafe提供了原子性操作方法。
 * 2. 什么是ABA问题？怎么解决？
 * 当一个值从A更新成B，又更新会A，普通CAS机制会误判通过检测。
 * 利用版本号比较可以有效解决ABA问题。
 */
@Slf4j
@ThreadSafe
public class ThreadExaple3 {
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws Exception {
        // 开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {

                }
                // 每个线程自增100次
                for (int j = 0; j < 100; j++) {
                    count.incrementAndGet();
                }
            }).start();
        }

        Thread.sleep(1000);
        log.info("{}", count.get());
    }

}
