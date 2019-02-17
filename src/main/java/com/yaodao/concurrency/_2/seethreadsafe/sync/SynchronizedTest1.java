package com.yaodao.concurrency._2.seethreadsafe.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yaodao
 * @Date: 2019/2/16 22:29
 */
@Slf4j
public class SynchronizedTest1 {

    /**
     * 1. 修饰方法和代码块，可称作对象锁，不同对象调用时将不存在锁；test1和test2都是对象锁，子类在继承时必须显示申明synchronized方法
     * 2. 修饰静态方法，整个静态方法，作用于所有对象，可称作类锁
     * 3. 修饰类，括号括起来部分，作用于所有对象，可称作类锁
     */
    // 修饰方法
    public synchronized void test1(int j){
        for (int i = 0; i < 10; i++){
            log.info("test1 {} - {}", j, i);
        }
    }

    // 修饰代码块
    public void test2(){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                log.info("test2 - {}", i);
            }
        }
    }

    // 修饰静态方法
    public static synchronized void test3(int j){
        for (int i = 0; i < 10; i++){
            log.info("test3 {} - {}", j, i);
        }
    }

    // 修饰一个类
    public void test4(int j){
        synchronized (SynchronizedTest1.class){
            for (int i = 0; i < 10; i++){
                log.info("test4 {} - {}", j, i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        SynchronizedTest1 synchronizedTest2 = new SynchronizedTest1();
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 第一轮测试
//        executorService.execute(() -> {
//            synchronizedTest1.test1(1);
//        });
//        executorService.execute(() -> {
//            synchronizedTest1.test1(1);
//        });
//
//        executorService.execute(() -> {
//            synchronizedTest1.test2();
//        });
//        executorService.execute(() -> {
//            synchronizedTest1.test2();
//        });


        // 第二轮测试
//        executorService.execute(() -> {
//            synchronizedTest1.test1(1);
//        });
//        executorService.execute(() -> {
//            synchronizedTest2.test1(2);
//        });


        // 第三轮测试
//        executorService.execute(() -> {
//            synchronizedTest1.test3(1);
//        });
//        executorService.execute(() -> {
//            synchronizedTest2.test3(2);
//        });

        // 第四轮测试
        executorService.execute(() -> {
            synchronizedTest1.test4(1);
        });
        executorService.execute(() -> {
            synchronizedTest2.test4(2);
        });
    }


}
