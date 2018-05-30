package com.domeastudio.mappingo.servers.microservice.surveying.util.tree;

import java.util.List;

public interface TreeEntity<E> {
    String getId();

    String getParentId();

    void setItems(List<E> childList);
}
