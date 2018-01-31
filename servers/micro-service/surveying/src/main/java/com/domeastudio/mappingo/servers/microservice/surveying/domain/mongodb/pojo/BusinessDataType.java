package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

public enum BusinessDataType {
    ZPT(1, "总评图"),
    JGT(2, "竣工图"),
    WTH(3, "委托函"),
    SLQRS(4, "四临确认书"),
    SFZ(5, "身份证"),
    GATSFZ(6, "港澳台身份证"),
    HZ(7, "护照"),
    HKB(8, "户口簿"),
    JGZ(9, "军官证(士兵证)"),
    ZZJGDM(10, "组织机构代码"),
    YYZZ(11, "营业执照"),
    QT(99, "其他");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int errcode) {
        this.code = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    BusinessDataType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
