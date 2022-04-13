package com.wuxin.bean;

import java.util.Objects;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/19:22
 * @Description:
 */
public class Car {

    /**
     * 车名称
     */
    private String name;

    /**
     * 车类型
     */
    private String type;

    /**
     * 车牌号
     */
    private String id;

    public Car(String name, String type, String id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 重写equals方法 如果 车牌号相等 说明是同一辆车
     *
     * @param obj Car 对象
     * @return true 表示相等 false表示不相等
     */
    @Override
    public boolean equals(Object obj) {
        Objects.requireNonNull(obj);
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return !this.id.isEmpty() && !car.id.isEmpty() && this.id.equals(car.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
