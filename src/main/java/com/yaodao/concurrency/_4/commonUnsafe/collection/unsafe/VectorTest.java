package com.yaodao.concurrency._4.commonUnsafe.collection.unsafe;

import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: yaodao
 * @Date: 2019/2/17 17:39
 */
@Slf4j
@NotThreadSafe
public class VectorTest {

    public static List<Integer> vector = new Vector<>();


    public static void main(String[] args) throws Exception {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }

}
