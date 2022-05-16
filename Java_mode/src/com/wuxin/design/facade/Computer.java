package com.wuxin.design.facade;

/**
 * @Author: wuxin001
 * @Date: 2022/05/17/0:30
 * @Description:
 */
public class Computer implements StartClose {

    private final CPU cpu;
    private final Disk disk;
    private final Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    @Override
    public void startup() {
        System.out.println("计算机启动中 ...");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("计算机启动完成 ...");
    }

    @Override
    public void close() {
        System.out.println("计算机关闭之前 ...");
        disk.close();
        memory.close();
        cpu.close();
        System.out.println("计算机成功关闭 ...");
    }
}
