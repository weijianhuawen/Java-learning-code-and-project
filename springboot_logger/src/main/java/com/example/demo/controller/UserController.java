package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class UserController {
//    private  final static Logger log = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/logger")
    public void sayHi() {
        log.trace("我是trace");
        log.info(("我是info"));
        log.debug("我是debug");
        log.error("我是error");
        log.warn("我是warn");
    }
}
