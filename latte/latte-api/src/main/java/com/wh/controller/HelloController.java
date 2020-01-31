package com.wh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @program: latte
 * @description:
 * @author: wh
 * @create: 2020-01-13 14:08
 */
@ApiIgnore
@RestController
public class HelloController {

    private final static Logger  log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Object hello(){
        log.debug("debug: hello~");
        log.info("info: hello~");
        log.warn("warn: hello~");
        log.error("error: hello~");
        return "hello";
    }

}
