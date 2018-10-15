package com.yaodao.concurrency.sharedata;

import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 以下代码理论上每次都应该为1000，可因为线程非安全不可能实现
 */
@Slf4j
@NotThreadSafe
public class ThreadExaple1 {
    volatile private static int count; // 由此可见volatile不能保证原子性
    public static void main(String[] args) throws Exception {
        // 开启10个线程
        for (int i = 0; i < 10; i++){
            new Thread(new Runnable(){
                @Override
                synchronized public void run() {
                    try {
                        Thread.sleep(1);
                    }catch (Exception e){

                    }
                    // 每个线程自增100次
                    for (int j = 0; j < 100; j++){
                        count++;
                    }
                }
            }).start();
        }

        Thread.sleep(1000);
        log.info("{}", count);
    }

}
