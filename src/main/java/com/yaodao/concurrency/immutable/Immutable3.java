package com.yaodao.concurrency.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.yaodao.concurrency.annoations.ThreadSafe;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过guava的ImmutableXXX修饰的集合，一旦修改其值就会抛出UnsupportedOperationException异常，
 * 与Collections.unmodifiableXXX实现方式类似
 * 配合final+ImmutableXXX修饰，实现一个不可变对象，此时是线程安全的
 *
 */
@Slf4j
@ThreadSafe
public class Immutable3 {
    private final static List<Integer> list1 = ImmutableList.of(1, 2, 3);
    private final static List<Integer> list2 = ImmutableList.<Integer>builder().add(3).add(4).build();
    private final static Map<Integer, Integer> map1 = ImmutableMap.of(1, 2, 3, 4, 5, 6);
    private final static Map<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(7, 8).put(9, 10).build();


    public static void main(String[] args) {
        map1.put(1, 21);
        map2.put(1, 2);
        list1.add(1);
        list2.add(1);
    }
}
