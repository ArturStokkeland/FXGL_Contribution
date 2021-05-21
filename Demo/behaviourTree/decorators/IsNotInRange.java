package advanced.behaviourTree.decorators;

import advanced.behaviourTree.BehaviourTreeSample;
import com.almasb.fxgl.btree.Decorator;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public class IsNotInRange extends Decorator {

    public IsNotInRange() {
    }

    @Override
    public Status evaluate(Entity entity) {

        if (entity.distance(FXGL.getGameWorld().getEntitiesByType(BehaviourTreeSample.EntityType.PLAYER).get(0)) > 100) {
            return Status.SUCCESS;
        }

        return Status.FAIL;
    }

}
