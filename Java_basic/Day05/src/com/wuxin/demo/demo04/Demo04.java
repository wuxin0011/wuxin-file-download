package com.wuxin.demo.demo04;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/23:10
 * @Description: 上转型 和下转型
 */
public class Demo04 {
    public static void main(String[] args) {
        // 动物对象
        Animals animals = new Animals();
        animals.move();

        Cat cat = new Cat();
        cat.move();

        Fish fish = new Fish();
        fish.move();

        // 向上转型 默认单继承 所有类默认继承 Object 如果指定了继承类 安装指定类继承
        // 向上转型体条件 1、必须有继承关系
        // 编译时候 编译的是Animals对象中move() 方法 所以编译通过，
        // 运行的时候由于指向的是 new Cat() 地址 所以调用的是 Cat 对象中 move() 方法
        Animals animals1 = new Cat();
        animals1.move();

        // 报错 java.lang.ClassCastException
        // 编译 不通过  animals 实际上是 new Animals() 对象 因此 cat1 指向的是 Animals
        // 但是编译的时候 cat1 中没有 catchMouse() 方法 因此编译不通过
        // Cat cat1 = (Cat) animals;

        // 编译通过  animals1 实际上是 new Cat() 对象 因此 cat2 指向的是 Cat 编译和运行都通过
        // 1、为什么要向下转型？
        // 目的是为了使用子类的方法
        Cat cat2 = (Cat) animals1;
        // 通过向下转型 可以访问 Cat 中catchMouse()方法 但是 animals1 是不能访问该方法的
        cat2.catchMouse();


    }
}

class Animals {

    void move() {
        System.out.println(this.getClass().getSimpleName() + "\t动物能够移动");
    }
}

class Cat extends Animals {

    void catchMouse() {
        System.out.println(this.getClass().getSimpleName() + "猫能够抓老鼠...");
    }

    @Override
    void move() {
        System.out.println(this.getClass().getSimpleName() + "\t能够在地上奔跑");
    }

}

class Fish extends Animals {

    void water() {
        System.out.println(this.getClass().getSimpleName() + "鱼能够游泳...");
    }

    @Override
    void move() {
        System.out.println(this.getClass().getSimpleName() + "\t鱼儿能够游泳...");
    }

}