package com.domeastudio.mappingo.servers.microservice.surveying.dto.response;

import java.util.List;

public class DhtmlxData {
    private DhtmlxSidebarData sidebarItem;
    private List<DhtmlxTreeViewObject> treeItems;
    private DhtmlxGridObject gridItems;


    public List<DhtmlxTreeViewObject> getTreeItems() {
        return treeItems;
    }

    public void setTreeItems(List<DhtmlxTreeViewObject> treeItems) {
        this.treeItems = treeItems;
    }

    public DhtmlxSidebarData getSidebarItem() {
        return sidebarItem;
    }

    public void setSidebarItem(DhtmlxSidebarData sidebarItem) {
        this.sidebarItem = sidebarItem;
    }

    public DhtmlxGridObject getGridItems() {
        return gridItems;
    }

    public void setGridItems(DhtmlxGridObject gridItems) {
        this.gridItems = gridItems;
    }
}
