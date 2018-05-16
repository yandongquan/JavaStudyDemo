package com.javakz;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 19:18 2018/4/27
 * @Modified By:
 */
public class Singleton {
    /**
     * 声明变量
     */
    private static Singleton instance;

    /**
     * Object类实例
     */
    private final static Object syncLock = new Object();

    /**
     * 私有构造函数
     */
    private Singleton() {}

    /**
     *  提供对外方法
     * @return 对象实例
     */
    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (syncLock) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
