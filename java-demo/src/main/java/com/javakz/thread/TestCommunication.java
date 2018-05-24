package com.javakz.thread;

/**
 * @Author: yandq
 * @Description: 测试类
 * @Date: Create in 16:36 2018/5/24
 * @Modified By:
 */
public class TestCommunication {
    public static void main(String[] args) {
        // 创建产品类（生产者和消费者操作的是同一个产品）
        Product product = new Product();
        // 创建两个线程
        Consumer c = new Consumer(product);
        Thread t1 = new Thread(c);
        Producer p = new Producer(product);
        Thread t2 = new Thread(p);
        // 启动两个线程
        t1.start();
        t2.start();
    }
}
