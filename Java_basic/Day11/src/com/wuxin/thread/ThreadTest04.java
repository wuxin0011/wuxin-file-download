package com.wuxin.thread;

/**
 * @Author: wuxin001
 * @Date: 2022/04/11/0:52
 * @Description: 测试线程其他方法
 */
public class ThreadTest04 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Go());

        thread.start();

        // 获取线程默认名称
        String name = thread.getName();
        System.out.println(name);

        // 自定义线程名称
        thread.setName("go-thread-01");
        System.out.println(thread.getName());

        // 守护线程
        // thread.setDaemon();

        // 默认优先级
        // thread.setPriority();

        // 获取线程类加载器
        ClassLoader contextClassLoader = thread.getContextClassLoader();
        System.out.println(contextClassLoader);
        ClassLoader parent = contextClassLoader.getParent();
        // 获取父类的类加载器
        System.out.println(parent.getClass().getSimpleName());

        // 获取当前线程执行对象
        Thread thread1 = Thread.currentThread();
        System.out.println(thread1.getName());

        // 激活的线程
        System.out.println(Thread.activeCount());

    }
}

class Go implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("" + this.getClass().getName() + "========>" + i);
        }
    }
}
