package com.yaodao.concurrency._10.basics.thread.ScopeOfVariableDemo.basic;

/**
 * @Author: yaodao
 * @Date: 2018/8/21 14:47
 */
public class Client {
    public static void main(String[] args) {
        Add add = new Add();
        //Add add2 = new Add(); 如果用不同的对象放到ThreadA和ThreadB，也不会出现线程安全问题，因为已经是不同对象了
        ThreadA threadA = new ThreadA(add);
        threadA.start();

        ThreadB threadB = new ThreadB(add);
        threadB.start();


        String str1 = "1";
        String str2 = "2";

        String str3 = "1" + "2";
        String str4 = str1 + str2;


        String str5 = "12";

        System.out.println(str3 == str4);
        System.out.println(str3 == str5);

    }
}
