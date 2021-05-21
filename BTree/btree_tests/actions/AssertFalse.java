package com.almasb.fxgl.pathfinding.btree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.entity.Entity;
import org.junit.jupiter.api.Test;

public class AssertFalse extends Action {

    @Override
    public Status execute(Entity entity) {
        assert(false);
        return Status.SUCCESS;
    }

}
