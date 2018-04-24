package com.javakz;

/**
 * @Author: yandq
 * @Description: 单例模式-懒汉式
 * @Date: Create in 10:24 2018/4/24
 * @Modified By:
 */
public class LazySingleton {
    /**
     * 声明变量
     */
    private static volatile LazySingleton lazySingleton = null;

    /**
     * 私有构造函数
     */
    private LazySingleton() {}

    /**
     *  提供对外方法
     * @return 对象实例
     */
    public static LazySingleton getLazySingleton() {
        if (lazySingleton==null) {
            synchronized (LazySingleton.class) {
                lazySingleton = new LazySingleton();
            }
        }
        return lazySingleton;
    }
}
