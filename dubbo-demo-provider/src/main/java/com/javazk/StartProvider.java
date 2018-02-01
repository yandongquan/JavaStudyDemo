package com.javazk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:22 2018/2/1
 * @Modified By:
 */
public class StartProvider {
    public static void main(String[] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dubbo-provider.xml") ;
        ac.start();
        System.out.println("服务提供者在注册中心暴露服务");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
