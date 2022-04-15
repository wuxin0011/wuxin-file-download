package com.wuxin.print;

import java.io.PrintStream;

/**
 * @Author: wuxin001
 * @Date: 2022/04/14/23:27
 * @Description: 探究 System.out.println()
 */
public class SystemOutPrint02 {

    public static void main(String[] args) {

        System.out.println("Demo");

        /*
         *    1、private System() {}
         *    System只有一个私有构造方法，无法new System
         *    ================================================
         *    2、 out -> public final static PrintStream out = null;
         *    out 能够调用  PrintStream 类中 println();
         *    那么 PrintStream out 对象是什么时候创建的呢？
         *
         *    3、初始化系统类。在线程初始化后调用。
         *    private static void initializeSystemClass() { .... 内容 }
         *    setOut0(newPrintStream(fdOut, props.getProperty("sun.stdout.encoding")));
         *    在这个方法中调用了 setOut0() 创建了new PrintStream()
         *
         */


        //

    }

}
