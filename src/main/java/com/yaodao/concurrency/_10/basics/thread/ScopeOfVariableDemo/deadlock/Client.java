package com.yaodao.concurrency._10.basics.thread.ScopeOfVariableDemo.deadlock;

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

class Deal extends Thread {
    private String userName;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            if ("a".equals(userName)) {
                synchronized (lock1) {
                    System.out.println("lock1_a...");
                    Thread.sleep(2000);
                    synchronized (lock2) {
                        System.out.println("lock2_a...");
                    }
                }
            }
            if ("b".equals(userName)) {
                synchronized (lock2) {
                    System.out.println("lock2_b...");
                    Thread.sleep(2000);
                    synchronized (lock1) {
                        System.out.println("lock1_b...");
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
