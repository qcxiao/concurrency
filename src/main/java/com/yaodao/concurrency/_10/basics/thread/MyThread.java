package com.yaodao.concurrency._10.basics.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: yaodao
 * @Date: 2018/8/20 16:47
 */
@Slf4j
public class MyThread extends Thread {
    @Override
    public void run(){
        log.info(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        log.info("执行完成");
    }
}
