package com.almasb.fxgl.btree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Node;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

import java.util.Iterator;

public class Inverter extends Action {

    @Override
    public Task.Status execute(Entity entity) {

        if (children.get(0).evaluate(entity) == Status.SUCCESS) {
            return Status.FAIL;
        }
        else {
            return Status.SUCCESS;
        }

    }

}
