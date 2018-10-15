package com.yaodao.concurrency._2.basics.thread.ScopeOfVariableDemo.basic;

/**
 * @Author: yaodao
 * @Date: 2018/8/21 14:44
 */
public class ThreadB extends Thread {
    private Add add;
    public ThreadB(Add add){
        this.add = add;
    }
    @Override
    public void run(){
        add.add("b");
    }
}
