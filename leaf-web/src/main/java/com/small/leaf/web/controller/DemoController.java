package com.small.leaf.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yefan
 * @Date: 2019/4/23 1:55 PM
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/test")
    public String test(){
        return "hello,world";
    }
}
