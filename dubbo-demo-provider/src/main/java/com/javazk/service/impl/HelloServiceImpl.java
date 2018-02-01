package com.javazk.service.impl;

import com.javazk.service.HelloService;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:34 2018/2/1
 * @Modified By:
 */
public class HelloServiceImpl implements HelloService {

    public String sayHello(String str) {
        return "Hello "+str;
    }
}
