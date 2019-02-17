package com.yaodao.concurrency._3.publish.immutable;

import com.google.common.collect.Maps;
import com.yaodao.concurrency._1.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * 通过Collections.unmodifiableXXX修饰的集合对象是不可变的，因此线程安全
 * 如下抛出异常：java.lang.UnsupportedOperationException
 * 原因：Collections.unmodifiableXXX修饰的集合，一旦调用其put、clear等方法时就直接抛出异常，阻止值修改
 *
 */
@Slf4j
@ThreadSafe
public class Immutable2 {
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,1);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 2);
        log.info("{}", map);
    }
}
