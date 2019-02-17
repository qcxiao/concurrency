/**
 *
 * 初看线程安全
 *
 *
 * 线程安全的体现：原子性、可见性、有序性
 * 通过Atomic、synchronized、Lock保证原子性
 * 通过volatile、synchronized保证可见性，但是volatile不适用于依赖自身操作的计算，适用场景是状态标识和double check
 * 有序性，happens-before原则
 *
 *
 *
 * 原子性对比：
 * synchronized，不可中断锁，适合竞争不激烈，可读性好
 * Lock，可中断锁，多样化同步，竞争激烈时能维持常态
 * Atomic，只能保证单个变量的原子性，竞争激烈时能维持常态，比Lock性能好
 *
 *
 * 有序性，happens-before原则：
 * 程序次序规则，一个线程内，按照代码顺序，书写在前的操作先行发生于书写在后的操作，用于保证程序在单线程中执行的正确性，但是无法保证程序在多线程中执行的正确性
 * 锁定规则，一个unlock操作先行发生于后面对同一个锁的lock操作，无论单线程还是多线程
 * volatile规则，对一个变量写操作先行发生于后面对这个变量的读操作
 * 传递规则，如果操作A先行发生于操作B，而操作B又先行于操作C，则可以得出操作A先行发生于操作C
 * 线程启动规则
 * 线程中断规则
 * 线程终结规则
 * 对象终结规则
 *
 *
 *
 * @Author: yaodao
 * @Date: 2019/2/16 17:40
 */
package com.yaodao.concurrency._2.seethreadsafe;