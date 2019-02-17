package com.yaodao.concurrency._2.seethreadsafe.atomic;

import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 */
@ThreadSafe
@Slf4j
public class AtomicTest3 {
    private static AtomicIntegerFieldUpdater<AtomicTest3> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicTest3.class, "count");

    /**
     * 必须由volatile修饰并且是public
     */
    @Getter
    public volatile int count = 100;

    private static AtomicTest3 atomicTest3 = new AtomicTest3();

    public static void main(String[] args) {
        if (updater.compareAndSet(atomicTest3, 100, 200)){
            log.info("update success, {}", atomicTest3.getCount());
        }
        if (updater.compareAndSet(atomicTest3, 200, 300)){
            log.info("update success, {}", atomicTest3.getCount());
        }
    }
}
