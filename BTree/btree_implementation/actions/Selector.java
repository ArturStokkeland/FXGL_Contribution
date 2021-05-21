package com.almasb.fxgl.btree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Node;
import com.almasb.fxgl.entity.Entity;

import java.util.Iterator;

public class Selector extends Action {

    @Override
    public Status execute(Entity entity) {

        Iterator<Node> childrenIterator = children.iterator();
        while (childrenIterator.hasNext()) {
            if (childrenIterator.next().evaluate(entity) == Status.SUCCESS) {
                return Status.SUCCESS;
            }
        }

        return Status.FAIL;

    }

}
