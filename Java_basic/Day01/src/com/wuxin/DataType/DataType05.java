package com.wuxin.DataType;
/*
	第一题：
		int a = 10;
		int b = 10;
		int c = 10;
		a = b++;
		c = --a;
		b = ++a;
		a = c--;
		请分别计算出a,b,c的值
	第二题：
		int a = 4;
		int b = (a++)+(++a)+(a*10);
*/

/**
 * @Author: wuxin001
 * @Date: 2022/03/19/18:01
 * @Description:
 */
public class DataType05 {

    public static void main(String[] args) {

        int a = 4;
        // 4 + 5
        int b = (a++)+(++a)+(a*10);
        System.out.println(b);
    }
}
