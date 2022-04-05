package com.wuxin.demo.demo03;

import com.wuxin.demo.demo01.Father;
import com.wuxin.demo.demo01.Son;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/22:55
 * @Description: 下转型
 */
public class Demo03 {
    public static void main(String[] args) {
        Son son = new Son(100);
        // 1、先向上转型
        Father father = (Father) son;
        father.hello(); // 在能够访问子类对应方法为public子类如果有方法调用子类 输出结果 hello son 调用子类 hello() 方法
        father.father(); // 调用Father类的 father() 方法 输出结果 hello  father()
        // 2、在向下转型
        Son son1 = (Son) father;
        System.out.println(son1);
        son1.hello();  // hello son
        son1.son(); // hello son()

        // 注意 下转型只能对经过上转型的对象进行下转型 如果直接下转型会报错 java.lang.ClassCastException
        // Father father1 = new Father();
        // Son sf = (Son) father1;
    }
}
