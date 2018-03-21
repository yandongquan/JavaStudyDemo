package com.javazhan;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 * @Author: yandq
 * @Description: 测试类
 * @Date: Create in 16:49 2018/3/21
 * @Modified By:
 */
public class TestConsumer {

    @Test
    public void testQueueconsumer() throws IOException {
        // 初始化 Spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 等待
        System.in.read();
    }
}
