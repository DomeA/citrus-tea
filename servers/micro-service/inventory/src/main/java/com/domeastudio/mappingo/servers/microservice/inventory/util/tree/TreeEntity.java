package com.domeastudio.mappingo.servers.microservice.inventory.util.tree;

import java.util.List;

public interface TreeEntity<E> {
    String getId();

    String getParentId();

    void setItems(List<E> childList);
}
