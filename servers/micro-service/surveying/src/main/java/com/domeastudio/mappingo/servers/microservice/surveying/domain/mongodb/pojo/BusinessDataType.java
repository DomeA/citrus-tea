package com.domeastudio.mappingo.servers.microservice.surveying.domain.mongodb.pojo;

public enum BusinessDataType {
    ZPT(1, "总评图"),
    SFZ(2, "身份证"),
    YYZZ(3, "营业执照"),
    JGT(4, "竣工图"),
    WTH(4, "委托函"),
    SLQRS(4, "四临确认书");

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
