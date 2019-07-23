package com.lww.learnjdk.Enum;

public enum StatusEnum {
    PAY(1, "PAY"),
    INCALL("INCALL");
    private String status;
    private int code;

    StatusEnum(String status) {
        this.status = status;
    }
    StatusEnum(int code, String status) {
        this.status = status;
        this.code = code;
    }

    public static void main(String[] args) {
        StatusEnum statusEnum = StatusEnum.INCALL;

        System.out.println(statusEnum);
    }
}
