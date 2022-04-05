package com.wuxin.DataType;

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/17:55
 * @Description:
 *
 *
 * 	++,--：自增自减运算符。
 * 	如果有一个变量i,
 * 		i++就表示这个值加1
 * 		i--就表示这个值减1
 * 	用法：
 * 		A:单独使用
 * 			放在操作数据的前后，效果一样。
 * 		B:参与操作使用
 * 			放在操作数前面，先自增或者自减，然后再参与运算
 * 			放在操作数后面，先参与运算，然后再自增或者自减
 *
 */
public class DataType04 {

    public static void main(String[] args) {
        System.out.println(5/3); // 1
        System.out.println(5%3); //2
        System.out.println(5%-3);//2
        System.out.println(-5%3);//-2

        int a = 10;
        int b = a++;
        System.out.println(a);//11
        System.out.println(b);//10
        System.out.println("------------");

        int c = 10;
        int d = ++c;
        System.out.println(c);//11
        System.out.println(d);//11

        System.out.println("------------");
        int e = 10;
        //e++;
        ++e;
        System.out.println(e);
    }
}
