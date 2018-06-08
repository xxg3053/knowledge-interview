package com.kenfo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.lambda
 * @Description: filter()过滤列表的使用
 * @date 2018/5/25 下午9:37
 */
public class CollectionFilterTest {

    public List<User> users = new ArrayList<User>();

    {
        users.add(new User("a", 10));
        users.add(new User("b", 11));

    }

    public static void main(String[] args) {
        CollectionFilterTest ct = new CollectionFilterTest();

        System.out.println("传统方法过滤---");
        List<User> ctUsers = new ArrayList<User>();
        for(User user:ct.users){
            if(!"a".equals(user.getName())){
                ctUsers.add(user);
            }
        }
        ctUsers.forEach(System.out::println);
        System.out.println("filter()过滤列表---");
        List<User> users = ct.users.stream().filter(user -> !"a".equals(user.getName())).collect(Collectors.toList());
        users.forEach(System.out::println);
        long count = ct.users.stream().filter(user-> !"a".equals(user.getName())).count();
        System.out.println("过滤后的大小：" + count);
        User user1 = ct.users.stream().filter(user-> !"a".equals(user.getName())).findFirst().orElse(null);


    }
}


class User{
    private String name;
    private int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:"+this.name+" age:" + this.age;
    }
}