package com.wuxin.map;

import com.wuxin.bean.User;

import java.util.HashMap;

/**
 * @Author: wuxin001
 * @Date: 2022/04/08/23:40
 * @Description: map几何
 */
public class MapDemo01 {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("key1", new User(1));
        map.put("key2", new User(2));
        map.put("key3", new User(3));
        map.put("key4", new User(4));

        System.out.println(map);
    }
}


