package com.wuxin.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java提供了java.util.regex包，用于与正则表达式进行模式匹配。
 * java.util.regex包主要由以下三个类组成 -
 * 1) Pattern
 * 2) Matcher
 * 3)PatternSyntaxException
 *
 * @author: wuxin001
 * @date: 2022/5/29 18:07
 * @Description: 添加内容 使用正则表达式
 */
public class DemoRegex01 {

    public static void main(String[] args) throws Exception {
        // String to be scanned to find the pattern.
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);


        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
        } else {
            System.out.println("NO MATCH");
        }

        // 是否能够匹配到
        boolean matches = line.matches(pattern);
        System.out.println(matches);
    }
}
