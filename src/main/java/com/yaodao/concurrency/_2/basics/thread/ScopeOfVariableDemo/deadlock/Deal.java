package com.yaodao.concurrency._2.basics.thread.ScopeOfVariableDemo.deadlock;

/**
 * @Author: yaodao
 * @Date: 2018/8/21 17:14
 */
public class Deal extends Thread{
    private String userName;

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setUserName(String userName){
        this.userName = userName;
    }
    @Override
    public void run(){
        try{
            if ("a".equals(userName)){
                synchronized (lock1){
                    System.out.println("lock1_a...");
                    Thread.sleep(2000);
                    synchronized (lock2){
                        System.out.println("lock2_a...");
                    }
                }
            }
            if ("b".equals(userName)){
                synchronized (lock2){
                    System.out.println("lock2_b...");
                    Thread.sleep(2000);
                    synchronized (lock1){
                        System.out.println("lock1_b...");
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
