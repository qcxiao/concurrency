package com.yaodao.concurrency.singleton;

import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式
 * 实例化的过程
 * 1. 向内存申请内存空间
 * 2. 创建实例
 * 3. 将创建的实例指向刚刚申请的内存空间
 *
 * 为了避免JVM指令重排，给实例加上volatile
 */
@Slf4j
@ThreadSafe
public class LazySingleton4 {
    private LazySingleton4() {
        log.info("LazySingleton4");
    }

    // volatile + 双重判断同步锁 -> 禁止指令重排，实现线程安全
    private volatile static LazySingleton4 instance = null;

    public static LazySingleton4 getInstance() {
        if (null == instance) {
            synchronized(LazySingleton4.class){ // 同步锁
                if (null == instance) {
                    instance = new LazySingleton4();
                }
            }
        }
        return instance;
    }
}
