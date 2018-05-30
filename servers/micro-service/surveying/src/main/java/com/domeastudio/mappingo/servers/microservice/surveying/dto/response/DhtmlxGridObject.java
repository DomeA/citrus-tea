package com.domeastudio.mappingo.servers.microservice.surveying.dto.response;

import java.util.List;

public class DhtmlxGridObject {
    private List<DhtmlxGridHeadObject> head;
    private List<DhtmlxGridRowObject> rows;

    public List<DhtmlxGridHeadObject> getHead() {
        return head;
    }

    public void setHead(List<DhtmlxGridHeadObject> head) {
        this.head = head;
    }

    public List<DhtmlxGridRowObject> getRows() {
        return rows;
    }

    public void setRows(List<DhtmlxGridRowObject> rows) {
        this.rows = rows;
    }
}
