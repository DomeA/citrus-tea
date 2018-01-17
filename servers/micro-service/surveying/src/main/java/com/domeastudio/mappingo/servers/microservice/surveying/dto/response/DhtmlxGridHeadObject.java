package com.domeastudio.mappingo.servers.microservice.surveying.dto.response;

import java.util.List;

public class DhtmlxGridHeadObject {
    private Integer width;
    private String type;
    private String align;
    private String sort;
    private String value;
    private List<DhtmlxGridHeadOptionObject> options;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DhtmlxGridHeadOptionObject> getOptions() {
        return options;
    }

    public void setOptions(List<DhtmlxGridHeadOptionObject> options) {
        this.options = options;
    }
}
