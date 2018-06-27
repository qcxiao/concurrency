package com.yaodao.concurrency.sharedata;

import com.yaodao.concurrency.annoations.NotThreadSafe;
import com.yaodao.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 加了同步锁，count自增的操作变成了原子性操作，所以实际值为1000
 * <p>
 * Synchronized关键字会让没有得到锁资源的线程进入BLOCKED状态，而后在争夺到锁资源后恢复为RUNNABLE状态，
 * 这个过程中涉及到操作系统用户模式和内核模式的转换，代价比较高。
 * <p>
 * 尽管Java1.6为Synchronized做了优化，增加了从偏向锁到轻量级锁再到重量级锁的过度，
 * 但是在最终转变为重量级锁之后，性能仍然较低。
 * <p>
 * 可以使用如下方法：
 * 原子操作类，指的是java.util.concurrent.atomic包下，一系列以Atomic开头的包装类。
 * 例如AtomicBoolean，AtomicInteger，AtomicLong。它们分别用于Boolean，Integer，Long类型的原子性操作。
 */
@Slf4j
@ThreadSafe
public class ThreadExaple2 {
    private static int count;

    public static void main(String[] args) throws Exception {
        // 开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {

                }
                // 每个线程自增100次
                for (int j = 0; j < 100; j++)
                    synchronized (ThreadExaple2.class) {
                        count++;
                    }
            }).start();
        }
        Thread.sleep(1000);
        log.info("{}", count);
    }
}
