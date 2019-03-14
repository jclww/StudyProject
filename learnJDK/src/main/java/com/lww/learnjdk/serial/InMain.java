package com.lww.learnjdk.serial;

import com.lww.learnjdk.serial.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person;

        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + person);
    }
}
