package com.lww.learnjdk.io.ObjectSerial;

import java.io.Serializable;

/**
 * Created by Lww on 2017/9/29.
 */
public class TestObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String age;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "TestObject{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /** GET SET **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
