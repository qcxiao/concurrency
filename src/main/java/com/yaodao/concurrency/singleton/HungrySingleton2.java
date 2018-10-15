package com.yaodao.concurrency.singleton;

import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式
 * 将实例化对象放到静态代码块中
 */
@Slf4j
@ThreadSafe
public class HungrySingleton2 {
    // 私有构造方法
    private HungrySingleton2() {
        log.info("HungrySingleton2");
    }
    // 单例实例，必须放到静态代码块之前，非实例化出来的对象为null
    private static HungrySingleton2 instance = null;

    static {
        instance = new HungrySingleton2();
    }

    // 静态的工厂方法
    public static HungrySingleton2 getInstance() {
        return instance;
    }
}
