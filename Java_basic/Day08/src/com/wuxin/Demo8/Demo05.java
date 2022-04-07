package com.wuxin.Demo8;

/**
 * @Author: wuxin001
 * @Date: 2022/04/01/21:33
 * @Description:
 */
public class Demo05 {

    public static void main(String[] args) {
        Person person = new Person("admin");
        System.out.println(Person.o2 == person);  // true
        Person person1 = new Person("admin1");
        System.out.println(Person.o2 == person1); // true
        System.out.println(person.hashCode() == person1.hashCode());
    }

}

class Person {
    public String name;
    public static Object o1 = null;
    public static Object o2 = null;

    {
        System.out.println("o1.this = " + this);
        o1 = this;
    }

    public Person() {

    }

    public Person(String name) {
        o2 = this;
        System.out.println("o1=" + o1 + "\to1.hashcode=" + o1.hashCode());
        System.out.println("o2=" + o2 + "\to2.hashcode=" + o2.hashCode());
        this.name = name;
    }
}
