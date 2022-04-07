package com.wuxin.demo.demo05;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/23:10
 * @Description:
 */
public class Demo05 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        User user = new User("tom");
        // 现在如果人需要添加一个宠物狗 不使用继承 就需要重新添加方法
        // 如果使用了继承，就不需要添加方法，减少代码重复添加，实现代码复用
        Dog dog = new Dog();
        dog.eat(dog, user);
        dog.sleep(dog, user);

        // 这个人还喜欢养鱼
        Fish fish = new Fish();
        fish.eat(fish, user);
        fish.sleep(fish, user);
    }
}
