package com.kenfo.equals;

import java.util.Objects;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.equals
 * @Description:
 * 对于JDK7及更新版本，你可以是使用java.util.Objects 来重写 equals 和 hashCode 方法，代码如下

 * @date 2018/4/24 下午5:48
 */
public class User2 {

    private String name;
    private int age;
    private String passport;

    //getters and setters, constructor

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User2)) {
            return false;
        }
        User2 user = (User2) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passport);
    }

}
