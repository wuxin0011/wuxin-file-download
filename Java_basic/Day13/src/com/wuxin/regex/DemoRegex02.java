package com.wuxin.regex;

/**
 * @author: wuxin001
 * @date: 2022/5/29 19:07
 * @Description:
 */
public class DemoRegex02 {

    public static void main(String[] args) {
        String phone = "18271660713";
        System.out.println(testPhone(phone));
    }


    /**
     * 测试手机号
     */
    public static boolean testPhone(String phone){
        if(phone == null || phone.isEmpty()){
            return false;
        }
        String regex = "^1([0-9]|5[0-3,5-9]|7[1-3,5-8]|8[0-9])\\d{8}$\n";
        return phone.matches(regex);
    }
}
