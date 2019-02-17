package com.yaodao.concurrency._3.publish.threadlocal;

/**
 * @Author: yaodao
 * @Date: 2019/2/17 11:16
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }


    public static Long get(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }



}
