package com.javakz.thread;

/**
 * @Author: yandq
 * @Description: 生产者线程
 * @Date: Create in 16:33 2018/5/24
 * @Modified By:
 */
public class Producer implements Runnable {
    private Product product;
    public Producer() {}
    public Producer(Product product) {
        this.product = product;
    }
    public void run() {
        int i = 0;
        while (true) {
            if (i % 2 == 0) {
                try {
                    product.put("馒头", "白色");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    product.put("玉米饼", "黄色");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }
}
