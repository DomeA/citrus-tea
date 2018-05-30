package com.domeastudio.mappingo.servers.microservice.surveying.dto.response;

import java.util.List;

public class DhtmlxGridRowObject {
    private String id;
    private List<Object> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
