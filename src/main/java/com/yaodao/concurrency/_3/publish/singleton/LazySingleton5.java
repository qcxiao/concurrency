package com.yaodao.concurrency._3.publish.singleton;

import com.yaodao.concurrency._1.annoations.Recommend;
import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式
 * 通过枚举实现，是最安全的
 */
@Slf4j
@ThreadSafe
@Recommend
public class LazySingleton5 {
    private LazySingleton5() {
        log.info("LazySingleton5");
    }

    private enum Single {
        INSTANCE;

        private LazySingleton5 singleton;

        // JVM保证这个方法被绝对的调用一次
        Single() {
            singleton = new LazySingleton5();
        }

        public LazySingleton5 getInstance() {
            return singleton;
        }
    }

    public static LazySingleton5 getInstance() {
        return Single.INSTANCE.getInstance();
    }
}
