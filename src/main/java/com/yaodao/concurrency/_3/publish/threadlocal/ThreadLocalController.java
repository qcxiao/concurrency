package com.yaodao.concurrency._3.publish.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yaodao
 * @Date: 2019/2/17 12:49
 */
@Controller
@RequestMapping(value = "threadlocal")
@Slf4j
public class ThreadLocalController {

    @RequestMapping("test")
    @ResponseBody
    public Long test(){
        log.info("into test method. ");
        return RequestHolder.get();
    }
}
