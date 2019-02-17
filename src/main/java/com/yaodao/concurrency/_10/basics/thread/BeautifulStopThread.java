package com.yaodao.concurrency._10.basics.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 优雅的停止线程
 * @Author: yaodao
 * @Date: 2018/8/20 21:07
 */
@Slf4j
public class BeautifulStopThread extends Thread {

    @Override
    public void run(){
        try {
            for (int i = 0; i < 500000; i++) {
                log.info("{}", i);
                if (this.interrupted()){
                    log.info("我即将退出");
                    throw new InterruptedException();
                }
            }
            log.info("for后的内容");
        }catch (InterruptedException e){
            log.info("进入了catch，退出成功");
        }
    }

    public static void main(String[] args) {
        try {
            BeautifulStopThread thread = new BeautifulStopThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
        } catch (Exception e){

        }
        log.info("---end---");
    }


}
