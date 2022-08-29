package com.wuxin.command;

/**
 *
 * 可以在编译的时候输出参数  如 javac CommandLine.java , java CommandLine 100 java参数 ...
 * @author: wuxin001
 * @date: 2022/5/29 18:07
 * @Description: 添加内容 命令行参数
 */
public class CommandLine {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("宁输入第 " + i + "个参数为 :" + args[i]);
        }
    }
}
