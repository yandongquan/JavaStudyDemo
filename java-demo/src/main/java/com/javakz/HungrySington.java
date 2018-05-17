package com.javakz;

/**
 * @Author: yandq
 * @Description: 单利模式-饿汉式
 * @Date: Create in 10:19 2018/4/24
 * @Modified By:
 */
public class HungrySington {

    /** 直接创建对象 */
    private static HungrySington hungrySington = new HungrySington();

    /** 私有化构造方法 */
    private HungrySington(){}

    /**
     * 返回对象实例
     * @return 对象实例
     */
    public static HungrySington getHungrySington() {
        return hungrySington;
    }
}
