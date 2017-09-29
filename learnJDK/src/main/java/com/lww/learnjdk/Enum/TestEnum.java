package com.lww.learnjdk.Enum;

/**
 * Created by Lww on 2017/9/29.
 */
public enum TestEnum {
    /**
     * 每个值都是TestEnum类型并且调用构造方法
     */
    ADD(1,"添加"),
    DELETE(2,"删除"),
    MODIFY(3,"修改"),
    SELECTE(4,"查找");


    /** 枚举的属性 **/
    int num;
    String name;

    TestEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    /** GET **/
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
