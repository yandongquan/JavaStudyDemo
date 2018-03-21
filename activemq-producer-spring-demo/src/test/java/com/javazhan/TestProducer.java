package com.javazhan;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 14:13 2018/3/21
 * @Modified By:
 */
public class TestProducer {

    @Test
    public void testActiveMQSpring() {
        // 初始化 Spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 从 Spring 容器中获取 JmsTemplate 对象
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        // 从 Spring 容器中取 Destination 对象
        Destination destination = (Destination)applicationContext.getBean("topicDestination");
        // 使用 JmsTemplate 对象发送消息
        jmsTemplate.send(destination, new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                // 创建一个消息对象并返回
                TextMessage textMessage = session.createTextMessage("spring activemq queue message");
                return textMessage;
            }
        });
    }

}
