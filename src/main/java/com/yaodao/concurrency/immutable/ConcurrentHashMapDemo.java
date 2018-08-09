package com.yaodao.concurrency.immutable;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yaodao
 * @Date: 2018/7/6 15:32
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put(1,12);
        if (!hashMap.containsKey(1))
            hashMap.put(1, 3);
        System.out.println(hashMap.toString());


        Hashtable hashtable = new Hashtable();
        hashtable.put(1, 2);
        if (!hashtable.containsKey(1))
            hashtable.put(1, 3);
        System.out.println(hashtable.toString());
    }
}
