package com.domeastudio.mappingo.servers.microservice.surveying.domain.postgresql.services.impl;

public enum ProcessType {
    SURVEY(1, "堪界流程"),
    BUILDING(2, "房产测绘流程"),
    CADASTRAL(3, "地籍测绘流程");

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

    ProcessType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
