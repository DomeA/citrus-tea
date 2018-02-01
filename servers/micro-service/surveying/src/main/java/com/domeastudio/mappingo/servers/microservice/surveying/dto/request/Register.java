package com.domeastudio.mappingo.servers.microservice.surveying.dto.request;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("register")
public class Register {
    private String name;
    private String loginName;
    private String pwd;
    private Boolean web;
    private Boolean app;
    private Boolean desktop;
    private String mac;
    private String equipmentid;
    private String email;
    private String phone;
    private Integer term;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Boolean getWeb() {
        return web;
    }

    public void setWeb(Boolean web) {
        this.web = web;
    }

    public Boolean getApp() {
        return app;
    }

    public void setApp(Boolean app) {
        this.app = app;
    }

    public Boolean getDesktop() {
        return desktop;
    }

    public void setDesktop(Boolean desktop) {
        this.desktop = desktop;
    }
}
