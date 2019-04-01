package com.lww.immutable;

import java.time.LocalDate;

final class Student {
    private final String name;
    private final int age;
    private final LocalDate dateJoined;

    public Student(String name, int age, LocalDate dateJoined) {
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }
}

public class TestImmutable {
    public static void main(String... args) {
        Student original = new Student("Yogen", 23, LocalDate.of(2016, 5, 1));
        LocalDate modifiedLocalDate = original.getDateJoined().plusYears(2);
        Student expected = new Student("Yogen", 23, LocalDate.of(2016, 5, 1));

        System.out.println(expected.equals(original));
    }
}