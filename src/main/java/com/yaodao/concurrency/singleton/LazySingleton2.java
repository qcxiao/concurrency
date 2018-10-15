package com.yaodao.concurrency.singleton;

import com.yaodao.concurrency._1.annoations.NotRecommend;
import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式
 * 这是线程安全的，但是可能造成大量线程的阻塞，不推荐使用这种方式
 */
@Slf4j
@ThreadSafe
@NotRecommend
public class LazySingleton2 {
    private LazySingleton2() {
        log.info("LazySingleton2");
    }

    private static LazySingleton2 instance = null;

    public static synchronized LazySingleton2 getInstance() {
        if (null == instance) {
            instance = new LazySingleton2();
        }
        return instance;
    }
}
