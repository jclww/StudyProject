package com.lww.myLog.test.obj;

import com.lww.myLog.log.enums.TestEnum;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lenovo
 * @data: 2017/11/8
 * @description: TestClassB
 */
public class TestClassB extends TestClassA {
    public int bInt;
    private String bString;

    private String isInt;
    private boolean boo;

    private int[] arr = new int[]{1,2,3};
    private String[] arrStr = new String[]{"a","b","c"};

//    public Value[] getArrV() {
//        return arrV;
//    }
//
//    public void setArrV(Value[] arrV) {
//        this.arrV = arrV;
//    }

    public Value[] arrV = new Value[] {
            new Value(),new Value()
    };

//    public Value getV() {
//        return V;
//    }
//
//    public void setV(Value v) {
//        V = v;
//    }

    public Value V = new Value();

    public Date date = new Date();

    public Map map = new HashMap<>();
    private HashMap map2 = new HashMap<>();

    public TestEnum anEnum = TestEnum.ADD;
    @Override
    public String toString() {
        return "TestClassB{" +
                "bInt=" + bInt +
                ", bString='" + bString + '\'' +
                '}';
    }

    public int getbInt() {
        return bInt;
    }

    public void setbInt(int bInt) {
        this.bInt = bInt;
    }

    public String getbString() {
        return bString;
    }

    public void setbString(String bString) {
        this.bString = bString;
    }

    public String getIsInt() {
        return isInt;
    }

    public void setIsInt(String isInt) {
        this.isInt = isInt;
    }
}
class Value {

}
