package com.wuxin.demo.demo05;

/**
 * @Author: wuxin001
 * @Date: 2022/03/24/23:10
 * @Description:
 */
public class User {

    private String name;
    private Pet pet;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return this.name;
    }
}
