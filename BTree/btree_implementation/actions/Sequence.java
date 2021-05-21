package com.almasb.fxgl.btree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Node;
import com.almasb.fxgl.entity.Entity;

import java.util.Iterator;

public class Sequence extends Action {

    @Override
    public Status execute(Entity entity) {

        Iterator<Node> childrenIterator = children.iterator();
        while (childrenIterator.hasNext()) {
            if (childrenIterator.next().evaluate(entity) == Status.FAIL) {
                return Status.FAIL;
            }
        }

        return Status.SUCCESS;

    }

}
