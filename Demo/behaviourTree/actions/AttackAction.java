package advanced.behaviourTree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.entity.Entity;

public class AttackAction extends Action {

    public AttackAction() {
    }

    @Override
    public Status execute(Entity entity) {

        System.out.println("Attacking");

        return Status.SUCCESS;
    }

}
