package com.lww.learnjdk.Enum;

/**
 * Created by Lww on 2017/9/29.
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(TestEnum.ADD.getName());
        System.out.println(TestEnum.ADD.getNum());
        System.out.println("compareTo:"+TestEnum.ADD.compareTo(TestEnum.SELECTE));

        System.out.println(TestEnum.ADD.ordinal());
        System.out.println(TestEnum.DELETE.ordinal());
        System.out.println(TestEnum.MODIFY.ordinal());
        System.out.println(TestEnum.SELECTE.ordinal());
        System.out.println(TestEnum.ADD.toString());


        TestEnum[] testEnums = TestEnum.values();
        for (TestEnum testEnum: testEnums) {
            System.out.println(testEnum.getName());
        }
    }
}
