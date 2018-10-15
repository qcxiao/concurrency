package com.yaodao.concurrency._2.basics.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: yaodao
 * @Date: 2018/8/20 17:17
 */
@Slf4j
public class MyRunnable implements Runnable {
    public MyRunnable(){
    }
    @Override
    public void run() {
        log.info(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        log.info("执行完成");
    }
}
