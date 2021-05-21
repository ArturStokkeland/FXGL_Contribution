package com.almasb.fxgl.btree;

import com.almasb.fxgl.btree.actions.Selector;
import com.almasb.fxgl.entity.Entity;

public class Node extends Task {

    private Decorator decorator;
    private Action action;

    public Node(Action myAction) {
        action = myAction;
    }

    public Node(Decorator myDecorator, Action myAction) {
        decorator = myDecorator;
        action = myAction;
    }

    public Status evaluate(Entity entity) {

        if(decorator != null) {

            if (decorator.evaluate(entity) == Status.FAIL) {

                return Status.FAIL;

            }

        }

        Status myCurrentStatus = action.execute(entity);

        if (myCurrentStatus == Status.SUCCESS) {
            return Status.SUCCESS;
        }
        else {
            return Status.FAIL;
        }

    }

    public Action getAction() {
        return action;
    }

    public Decorator getDecorator() { return decorator; }

}
