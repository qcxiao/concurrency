package com.yaodao.concurrency._2.basics.thread.ScopeOfVariableDemo.basic;

/**
 * int num = 0;局部变量存在于虚拟机栈中的栈帧里的局部变量表中，是每个线程独享的，所以不存在线程安全问题
 * private int num = 0;成员变量存在于方法区中，是线程共享的，所以存在线程安全问题，因时可以通过synchronized关键字加在方法上解决
 * 特别注意：
 * 1. synchronized的作用域：类、方法、代码块，针对对象：this、class、实例对象变量、方法参数
 * 2. 静态同步synchronized方法与class是一样的，为此class类上锁后此类对象都持有同一把锁
 * 3. class与this，是持有不同的锁
 *
 * @Author: yaodao
 * @Date: 2018/8/21 14:41
 */
public class Add {
    private int num = 0;

    // 普通synchronized方法
    synchronized public void add(String username) {
        try {
            if ("a".equals(username)) {
                num = 100;
                Thread.sleep(1000);
                System.out.println("a执行结束");
            } else {
                num = 200;
                System.out.println("b执行结束");
            }
            System.out.println("username=" + username + ",num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 代码块this类比于对普通synchronized方法加锁
    public void add1(String username) {
        synchronized (this) {
            try {
                if ("a".equals(username)) {
                    num = 100;
                    Thread.sleep(1000);
                    System.out.println("a执行结束");
                } else {
                    num = 200;
                    System.out.println("b执行结束");
                }
                System.out.println("username=" + username + ",num=" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object object = new Object();
    // 代码块实例变量或方法参数作为对象锁，此对象的所有synchronized方法或代码块都持有同一把锁，并同步执行
    // 但是不能用String类型作为锁，因为会有String常量池带来的问题
    public void add2(String username) {
        synchronized (object) {
            try {
                if ("a".equals(username)) {
                    num = 100;
                    Thread.sleep(1000);
                    System.out.println("a执行结束");
                } else {
                    num = 200;
                    System.out.println("b执行结束");
                }
                System.out.println("username=" + username + ",num=" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 静态同步synchronized方法与class是一样的，因此class类上锁后此类对象都持有同一把锁
    public void add3(String username) {
        synchronized (Add.class) {
            try {
                if ("a".equals(username)) {
                    num = 100;
                    Thread.sleep(1000);
                    System.out.println("a执行结束");
                } else {
                    num = 200;
                    System.out.println("b执行结束");
                }
                System.out.println("username=" + username + ",num=" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 静态同步synchronized方法与class是一样的，因此静态同步synchronized方法上锁后此类对象都持有同一把锁
    // synchronized public void add(String username)，这是持有当前对象的锁，与class类锁不是同一把锁
    synchronized public static void add5(String username) {
        int num = 0;
        try {
            if ("a".equals(username)) {
                num = 100;
                Thread.sleep(1000);
                System.out.println("a执行结束");
            } else {
                num = 200;
                System.out.println("b执行结束");
            }
            System.out.println("username=" + username + ",num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
