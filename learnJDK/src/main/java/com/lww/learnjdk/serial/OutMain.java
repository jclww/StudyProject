package com.lww.learnjdk.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutMain {
    public static void main(String[] args) throws IOException {
        Person person = new Person(1234, "wang", 100);
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }

}
