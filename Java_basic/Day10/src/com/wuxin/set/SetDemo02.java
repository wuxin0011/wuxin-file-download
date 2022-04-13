package com.wuxin.set;

import com.wuxin.bean.Car;

import java.util.HashSet;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/23:46
 * @Description:
 */
public class SetDemo02 {

    public static void main(String[] args) {
        HashSet<Car> hashSet = new HashSet<>();

        hashSet.add(new Car("name1", "jidfae", "1fccdaf1"));
        hashSet.add(new Car("name2", "jidfad", "1fccdaf"));
        hashSet.add(new Car("name3", "jidfae", "1fccdaf"));
        hashSet.add(new Car("name4", "jidfad", "1fccdaf1"));

        Car car1 = new Car("name411", "jidfad", "1fccdaf1");
        Car car2 = new Car("name421", "jidfad", "1fccdaf1");

        System.out.println(car2.equals(car1));

        // 添加相同内容测试
        hashSet.add(new Car("name4", "jidfad", "1fccdaf1"));

        System.out.println(hashSet.size());

        System.out.println(hashSet);

        // 遍历
        hashSet.forEach(System.out::println);
    }
}
