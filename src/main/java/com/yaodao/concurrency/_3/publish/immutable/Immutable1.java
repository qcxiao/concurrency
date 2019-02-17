package com.yaodao.concurrency._3.publish.immutable;

import com.google.common.collect.Maps;
import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


/**
 * 1. 对final修饰的Integer类型，无法再对其赋值，编译报错
 * 2. 对final修饰的String类型，无法再对其赋值，编译报错
 * 3. 对final修饰的Map类型，可以对其赋值并且能够真正修改Map里的key、value，如下：会输出{1=2}
 * 总结：
 * 1. final修饰的基本数据类型，是无法修改其值
 * 2. final修饰的引用数据类型，是无法修改其指向的对象引用，而是可以修改其值的
 * 3. 因此通过final修饰的对象，不能保证就是不可变对象，因此线程非安全
 */
@Slf4j
@NotThreadSafe
public class Immutable1 {
    private final static Integer i = 0;
    private final static String j = "j";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,1);
    }

    public static void main(String[] args) {
        map.put(1, 2);
        log.info("{}", map);
    }
}
