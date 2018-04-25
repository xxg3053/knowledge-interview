package com.kenfo.equals;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.equals
 * @Description:
 * 您可以使用Apache Commons LangEqualsBuilder 和HashCodeBuilder 方法。代码如下
 * @date 2018/4/24 下午5:49
 */
public class User3 {

    private String name;
    private int age;
    private String passport;
    //getters and setters, constructor

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof User3)) {
            return false;
        }
        User3 user = (User3) o;

        return new EqualsBuilder()
                .append(age, user.age)
                .append(name, user.name)
                .append(passport, user.passport)
                .isEquals();
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(age)
                .append(passport)
                .toHashCode();
    }
}
