package com.domeastudio.mappingo.servers.microservice.surveying.dto.response;

import com.domeastudio.mappingo.servers.microservice.surveying.util.tree.TreeEntity;

import java.util.List;

public class DhtmlxTreeViewObject implements TreeEntity<DhtmlxTreeViewObject> {
    private String id;
    private String parentId;
    private String code;
    private String type;
    private String icons;
    private String open;
    private String checkbox;
    private int checked;
    private String text;
    private Boolean selected;
    private Object userdata;
    private List<DhtmlxTreeViewObject> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Object getUserdata() {
        return userdata;
    }

    public void setUserdata(Object userdata) {
        this.userdata = userdata;
    }

    public List<DhtmlxTreeViewObject> getItems() {
        return items;
    }

    public void setItems(List<DhtmlxTreeViewObject> items) {
        this.items = items;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String getParentId() {
        return parentId;
    }
}
