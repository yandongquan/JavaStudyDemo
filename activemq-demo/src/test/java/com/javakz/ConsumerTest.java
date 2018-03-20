package com.javakz;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * @Author: yandq
 * @Description: 消费者
 * @Date: Create in 16:34 2018/3/20
 * @Modified By:
 */
public class ConsumerTest {

    /**
     * 测试Queue
     * 消费者：接收消息
     * @throws JMSException
     * @throws IOException
     */
    @Test
    public void testQueueConsumer() throws JMSException, IOException {
        // 1）创建一个 ConnectionFactory 对象。
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.0.113:61616");
        // 2）从 ConnectionFactory 对象中获得一个 Connection 对象。
        Connection connection = connectionFactory.createConnection();
        // 3）开启连接。调用 Connection 对象的 start 方法。
        connection.start();
        // 4）使用 Connection 对象创建一个 Session 对象。
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // 5）使用 Session 对象创建一个 Destination 对象。和发送端保持一致 queue，并且队列的名称一致。
        Queue queue = session.createQueue("test-queue");
        // 6）使用 Session 对象创建一个 Consumer 对象。
        MessageConsumer consumer = session.createConsumer(queue);
        // 7）接收消息。
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                String text = null;
                // 取消息内容
                try {
                    text = textMessage.getText();
                    // 8）打印消息。
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        String textMessage = consumer.getMessageSelector();

        // 等待键盘输入
        System.in.read();
        // 9）关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

    /**
     * 测试Topic
     * 消费者：接收消息
     */
    @Test
    public void testTopicCusumer() throws JMSException, IOException {
        // 1）创建一个 ConnectionFactory 对象。
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.0.113:61616");
        // 2）从 ConnectionFactory 对象中获得一个 Connection 对象。
        Connection connection = connectionFactory.createConnection();
        // 3）开启连接。调用 Connection 对象的 start 方法。
        connection.start();
        // 4）使用 Connection 对象创建一个 Session 对象。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5）使用 Session 对象创建一个 Destination 对象。和发送端保持一致 topic，并且话题的名称一致。
        Topic topic = session.createTopic("test-topic");
        // 6）使用 Session 对象创建一个 Consumer 对象。
        MessageConsumer consumer = session.createConsumer(topic);
        // 7）接收消息。
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                String text = null;
                try {
                    text = textMessage.getText();
                    // 8）打印消息。
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("topic 的消费端............");
        // 等待键盘输入
        System.in.read();
        // 9）关闭资源
        consumer.close();
        session.close();
        connection.close();
    }

}
