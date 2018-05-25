package com.kenfo.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.lambda
 * @Description: 使用lambda表达式对列表进行迭代
 * @date 2018/5/15 下午11:32
 */
public class CollectionTest {

    public static void main(String[] args) {
        // Java 8之前：
        List<String> features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features1) {
            System.out.println(feature);
        }
        // Java 8之后：
        List features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features2.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features2.forEach(System.out::println);
    }
}
