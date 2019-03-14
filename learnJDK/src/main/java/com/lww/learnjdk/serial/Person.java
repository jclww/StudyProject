package com.lww.learnjdk.serial;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1234567890L;
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + id
                + ",name:" + name
                ;
    }
}
