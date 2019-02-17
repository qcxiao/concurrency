package com.yaodao.concurrency._3.publish.singleton;

import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式
 * 这是线程不安全的，原因是多个线程可能同时判断instance是否为null，然后同时创建对象并返回不同的对象
 */
@Slf4j
@NotThreadSafe
public class LazySingleton1 {

    // 私有构造方法
    private LazySingleton1() {
        log.info("LazySingleton1");
    }

    // 单例实例
    private static LazySingleton1 instance = null;

    // 静态的工厂方法
    public static LazySingleton1 getInstance() {
        if (null == instance) {
            instance = new LazySingleton1();
        }
        return instance;
    }
}
