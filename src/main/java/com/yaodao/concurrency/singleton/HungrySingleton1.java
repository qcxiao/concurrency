package com.yaodao.concurrency.singleton;

import com.yaodao.concurrency.annoations.NotThreadSafe;
import com.yaodao.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式
 * 在类装载时就创建实例，但是有两个问题：
 * 1. 如果实例化过程中涉及大量的操作时会导致类装载慢，影响整个装载过程
 * 2. 如果创建的对象并没有得到应用，将造成资源的浪费
 */
@Slf4j
@ThreadSafe
public class HungrySingleton1 {

    // 私有构造方法
    private HungrySingleton1() {
        // 例如以下可能导致类装载过慢
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("HungrySingleton1");
    }

    // 单例实例
    private static HungrySingleton1 instance = new HungrySingleton1();

    // 静态的工厂方法
    public static HungrySingleton1 getInstance() {
        return instance;
    }
}
