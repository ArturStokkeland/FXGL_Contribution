package com.almasb.fxgl.btree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

public class AlwaysSucceed extends Action {

    @Override
    public Task.Status execute(Entity entity) {

        children.get(0).evaluate(entity);
        return Status.SUCCESS;

    }

}
