package com.lww.learnjdk.io.ObjectSerial;

import java.io.*;

/**
 * Created by Lww on 2017/9/29.
 */
public class ObjectOut {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "A:/Java/io/object/TestObject.lww";
        File file = new File(fileName);

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            if (file.exists()) {
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        outFile();
        outObject();
        readObject();




    }

    private static void readObject() throws IOException, ClassNotFoundException {
        String fileName = "A:/Java/io/object/TestObject.lww";

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                fileName));
        TestObject t = (TestObject) oin.readObject();
        System.out.println(t.toString());
        oin.close();
    }

    private static void outObject() throws IOException {
        String fileName = "A:/Java/io/object/TestObject.lww";

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName));
        TestObject test1 = new TestObject();
        test1.setAddress("asdas");
        test1.setAge("12");
        test1.setName("暗示的打");
        test1.setPhone("1312312312");

//        out.writeInt(20131015);

        out.writeObject(test1);

        out.close();
    }

    private static void outFile() {
        String fileName = "A:/Java/io/object/TestObject.lww";
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream(fileName));

        out.writeBoolean(true);
        out.writeByte((byte)65);
        out.writeChar('a');
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
