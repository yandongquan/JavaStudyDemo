package com.javazk;

import com.javazk.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 11:59 2018/2/1
 * @Modified By:
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "dubbo-consumer.xml" });
        context.start();

        HelloService helloService = (HelloService) context.getBean("helloService");
        //调用该服务
        System.out.println(helloService.sayHello("hhhh"));

        System.in.read();
    }
}
