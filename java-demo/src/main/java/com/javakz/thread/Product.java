package com.javakz.thread;

/**
 * @Author: yandq
 * @Description: 产品类
 * @Date: Create in 16:29 2018/5/24
 * @Modified By:
 */
public class Product {
    /** 馒头  玉米饼 */
    private String name;
    /** 白色  黄色 */
    private String color;
    /** 是否生产产品 */
    private boolean isProduce = false;
    public synchronized void get() throws InterruptedException {
        // 如果没有生产，等待
        if(isProduce == false){
            wait();
        }
        // 消费产品
        System.out.println("消费者消费："+name+" "+color);
        // 修改状态：没有生产
        isProduce = false;
        // 通知生产者生产
        notify();
    }

    public synchronized void put(String name,String color) throws InterruptedException {
        // 如果已经生产，等待
        if(isProduce == true){
            // 生产产品
            wait();
            this.name = name;this.color = color;
            System.out.println("生产者生产："+this.name+" "+this.color);
            // 修改状态：已经生产
            isProduce = true;
            // 通知消费者消费
            notify();
        }
    }
}
