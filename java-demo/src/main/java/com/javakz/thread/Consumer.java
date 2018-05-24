package com.javakz.thread;

/**
 * @Author: yandq
 * @Description: 消费者线程
 * @Date: Create in 16:35 2018/5/24
 * @Modified By:
 */
public class Consumer implements Runnable {
    private Product product;
    public Consumer() {
        super();
    }
    public Consumer(Product product) {
        super();
        this.product = product;
    }
    public void run() {
        while(true){
            try {
                product.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
