package com.almasb.fxgl.btree;

import com.almasb.fxgl.entity.Entity;

public abstract class Decorator extends Task {

    public abstract Status evaluate(Entity entiy);

}
