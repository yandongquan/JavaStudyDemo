package com.javazhan.system;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @Author: yandq
 * @Description: MessageListener 的实现类
 * @Date: Create in 16:40 2018/3/21
 * @Modified By:
 */
public class MyMessageListener implements javax.jms.MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage)message;
            // 取消息
            String text = textMessage.getText();
            System.out.println(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
