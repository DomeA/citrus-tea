package com.domeastudio.mappingo.servers.microservice.inventory.dto.response;

import java.util.List;

public class DhtmlxData {
    private DhtmlxSidebarData sidebarItem;
    private List<DhtmlxTreeViewObject> treeItem;
    private DhtmlxGridObject gridItem;
    private DhtmlxToolbarData toolbarItem;

    public DhtmlxSidebarData getSidebarItem() {
        return sidebarItem;
    }

    public void setSidebarItem(DhtmlxSidebarData sidebarItem) {
        this.sidebarItem = sidebarItem;
    }

    public List<DhtmlxTreeViewObject> getTreeItem() {
        return treeItem;
    }

    public void setTreeItem(List<DhtmlxTreeViewObject> treeItem) {
        this.treeItem = treeItem;
    }

    public DhtmlxGridObject getGridItem() {
        return gridItem;
    }

    public void setGridItem(DhtmlxGridObject gridItem) {
        this.gridItem = gridItem;
    }

    public DhtmlxToolbarData getToolbarItem() {
        return toolbarItem;
    }

    public void setToolbarItem(DhtmlxToolbarData toolbarItem) {
        this.toolbarItem = toolbarItem;
    }
}
