package com.almasb.fxgl.btree;

import com.almasb.fxgl.entity.Entity;
import java.util.ArrayList;
import java.util.List;

public abstract class Action extends Task {

    protected List<Node> children;

    public Action() {
        children = new ArrayList<Node>();
    }

    public abstract Status execute(Entity entity);

    public void addChild (Node myNode) {
        children.add(myNode);
    }

}
