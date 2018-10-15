package com.yaodao.concurrency._2.basics.thread.ScopeOfVariableDemo.deadlock;

/**
 * @Author: yaodao
 * @Date: 2018/8/21 17:22
 */
public class Client {
    public static void main(String[] args) {
        Deal deal = new Deal();
        deal.setUserName("a");
        new Thread(deal).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deal.setUserName("b");
        new Thread(deal).start();
    }
}
