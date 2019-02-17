package com.yaodao.concurrency._3.publish.singleton;

import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式
 * 双重判断同步锁，但是是线程不安全的，分析一下实例化的过程
 * 1. memory = allocate() 分配对象的内存空间
 * 2. ctorInstance() 初始化对象
 * 3. instance = memory 设置instance指向刚分配的内存
 * <p>
 * 但是，此时JVM和CPU优化，发生指令重排，导致上面的执行顺序可能按照1、3、2进行
 * 因此，当一个线程按照1、3、2进行了，另一个线程得到的实例可能是一个空指针
 */
@Slf4j
@NotThreadSafe
public class LazySingleton3 {
    private int i = 1;

    private LazySingleton3() {

        log.info("LazySingleton3");
    }

    private static LazySingleton3 instance = null;

    public static LazySingleton3 getInstance() {
        if (null == instance) {
            synchronized (LazySingleton3.class) {// 同步锁
                if (null == instance) {
                    instance = new LazySingleton3();
                }
            }
        } else {
            log.info("{}", instance.i++);
        }

        return instance;
    }
}
