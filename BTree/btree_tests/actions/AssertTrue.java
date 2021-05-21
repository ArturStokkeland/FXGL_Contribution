package com.almasb.fxgl.pathfinding.btree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

public class AssertTrue extends Action {

    @Override
    public Task.Status execute(Entity entity) {
        assert(true);
        return Task.Status.SUCCESS;
    }

}
