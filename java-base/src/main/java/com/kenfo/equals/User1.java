package com.kenfo.equals;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.equals
 * @Description: 这种17和31散列码的想法来自经典的Java书籍——《Effective Java》
 * @date 2018/4/24 下午5:47
 */
public class User1 {

    private String name;
    private int age;
    private String passport;

    public User1(String name, int age, String passport){
        this.name = name;
        this.age = age;
        this.passport=passport;
    }
    //getters and setters, constructor
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User1)) {
            return false;
        }
        User1 user = (User1) o;
        return user.name.equals(name) &&
                user.age == age &&
                user.passport.equals(passport);
    }
    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        return result;
    }
}
