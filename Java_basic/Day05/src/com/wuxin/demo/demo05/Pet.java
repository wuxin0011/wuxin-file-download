package com.wuxin.demo.demo05;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/23:10
 * @Description:
 */
public class Pet {

    public void eat(Pet pet,User user) {
        System.out.println(user.getName()+"的宠物" + pet.getClass().getSimpleName() + "吃东西");
    }

    public void sleep(Pet pet,User user) {
        System.out.println(user.getName()+"的宠物"  + pet.getClass().getSimpleName() + "在睡觉");
    }
}
