package com.yaodao.concurrency._10.basics.thread.ScopeOfVariableDemo.basic;

/**
 * @Author: yaodao
 * @Date: 2018/8/21 14:44
 */
public class ThreadA extends Thread {
    private Add add;
    public ThreadA(Add add){
        this.add = add;
    }
    @Override
    public void run(){
        add.add("a");
    }
}
