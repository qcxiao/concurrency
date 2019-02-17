package com.yaodao.concurrency._10.basics.thread.ScopeOfVariableDemo;

/**
 * @Author: yaodao
 * @Date: 2018/10/30 10:14
 * 原子性问题
 * 解决方案：
 * 1. inc()上通过synchronzied加锁实现
 */
public class AtomicDemo {
    private static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::inc).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
