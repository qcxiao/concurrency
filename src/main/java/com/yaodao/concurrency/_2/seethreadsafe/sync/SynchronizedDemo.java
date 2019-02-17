package com.yaodao.concurrency._2.seethreadsafe.sync;

/**
 * 分析Synchronized作用于静态方法、普通方法、代码块的不同锁机制
 * 通过javap -v 命令作用于class文件:
 * 1. 代码块通过monitorenter和monitorexit保证线程安全
 * 2. 静态方法和普通方法从常量池的方法表中取得ACC_SYNCHRONIZED标识区分此方法是否是同步方法，
 * 当synchronized修饰的方法被调用时，调用指令会检查方法的 ACC_SYNCHRONIZED 是否被设置，
 * 如果设置了，执行线程将先持有monitor， 然后再执行方法，最后在方法完成时释放monitor。
 * 在方法执行期间，执行线程持有了monitor，其他任何线程都无法再获得同一个monitor。
 */
public class SynchronizedDemo {
    public static synchronized void method1(){
        System.out.println("method1");
    }
    public synchronized void method2(){
        System.out.println("method2");
    }
    public void method3(){
        synchronized(SynchronizedDemo.class){

        }
    }
}
/**
以下是反编译的信息：
 Last modified 2018-4-12; size 635 bytes
 MD5 checksum eb80ac44213b711f7218c9088d74db5e
 Compiled from "SynchronizedDemo.java"
 public class com.yaodao.concurrency.singleton.SynchronizedDemo
 minor version: 0
 major version: 52
 flags: ACC_PUBLIC, ACC_SUPER
 {
 public com.yaodao.concurrency.singleton.SynchronizedDemo();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=1, locals=1, args_size=1
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return
 LineNumberTable:
 line 7: 0
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0       5     0  this   Lcom/yaodao/concurrency/singleton/SynchronizedDemo;

 public static synchronized void method1();
 descriptor: ()V
 flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
 Code:
 stack=0, locals=0, args_size=0
 0: return
 LineNumberTable:
 line 8: 0

 public synchronized void method2();
 descriptor: ()V
 flags: ACC_PUBLIC, ACC_SYNCHRONIZED
 Code:
 stack=0, locals=1, args_size=1
 0: return
 LineNumberTable:
 line 9: 0
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0       1     0  this   Lcom/yaodao/concurrency/singleton/SynchronizedDemo;

 public void method3();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=2, locals=3, args_size=1
 0: ldc           #2                  // class com/yaodao/concurrency/singleton/SynchronizedDemo
 2: dup
 3: astore_1
 4: monitorenter
 5: aload_1
 6: monitorexit
 7: goto          15
 10: astore_2
 11: aload_1
 12: monitorexit
 13: aload_2
 14: athrow
 15: return
 Exception table:
 from    to  target type
 5     7    10   any
 10    13    10   any
 LineNumberTable:
 line 11: 0
 line 13: 5
 line 14: 15
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      16     0  this   Lcom/yaodao/concurrency/singleton/SynchronizedDemo;
 StackMapTable: number_of_entries = 2
 frame_type = 255
 SourceFile: "SynchronizedDemo.java"
*/
