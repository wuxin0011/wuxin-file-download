package com.wuxin.en;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/8:25
 * @Description: 枚举 单例模式
 */
public class Demo01 {

    public static void main(String[] args) {
        Age man = Age.MAN;
        System.out.println(man);
        System.out.println(man.hashCode());
        System.out.println(man == Age.MAN);

        Age women1 = Age.WOMEN;
        Age women2 = Age.WOMEN;
        System.out.println(women1.hashCode());
        System.out.println(women1);
        System.out.println(women1.equals(women2));

        // 枚举不能new

    }
}

enum Age {

    /**
     * 男
     */
    MAN(1),

    /**
     * 女
     */
    WOMEN(2);


    private Integer sex;

    Age(Integer sex) {
        this.sex = sex;
    }


}
