package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.pojo;

public enum BusinessType {
    HOUSE_LAYER(1,"房产分户"),
    HOUSE_FORECAST(2,"房产预测"),
    CADASTRE_SURVEY(3,"地籍测量"),
    OTHER(9,"其他");

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

    BusinessType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
