package com.wuxin;

/**
 * 时间复杂度 8 种
 * 1、排序算法 可以参考 ：https://blog.csdn.net/weixin_44531966/article/details/116464294
 * @Author: wuxin001
 * @Date: 2022/04/22/21:48
 * @Description:
 */
public class Demo00 {

    public static void main(String[] args) {

        test01();
    }

    static void test01() {
        int a = 100;
        int b = a++;
        int c = ++a;
        int d = (a++) + (++a);
        // 分析 a++ 和 ++a的优先级不同 ++a的优先级 > 等号的优先级 > a++的优先级
        // 因此 b 先等于a 然后 a++ b = 100
        // c ++a的优先级比 "=" 大 因此 a先运算 c = 102
        // d 先计算 ++a 然后参与 a + a 等号赋值完毕之后 a++ 因此 d = 103+103 ，最后执行a++操作，因此 a = 104
        // a=104,b=100,c=102,d=206
        System.out.printf("a=%d,b=%d,c=%d,d=%d\n", a, b, c, d);
        // 虽然这里有一些计算，但是都是从上直接到下，时间复杂度为 o(1)
    }
}
