package com.yaodao.concurrency._3.publish;

import com.yaodao.concurrency._1.annoations.NotRecommend;
import com.yaodao.concurrency._1.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 对象逸出
 * @Author: yaodao
 * @Date: 2019/2/16 23:55
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
