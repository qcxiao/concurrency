package com.yaodao.concurrency._10.basics.thread.ScopeOfVariableDemo;

/**
 * @Author: yaodao
 * @Date: 2018/10/30 09:58
 * 可见性问题
 */
public class VisabledDemo {
    //private static boolean stop = false;

    // volatile可以使变量具备可见性
    private volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
                // io操作会引起缓存失效，从而出现线程切换
                // System.out.println("i:" + i);
            }
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;
    }
}
