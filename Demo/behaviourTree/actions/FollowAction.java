package advanced.behaviourTree.actions;

import advanced.behaviourTree.BehaviourTreeSample;
import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;

public class FollowAction extends Action {

    public FollowAction() {
    }

    @Override
    public Status execute(Entity entity) {

        entity.translateTowards(FXGL.getGameWorld().getEntitiesByType(BehaviourTreeSample.EntityType.PLAYER).get(0).getPosition(), 4);
        System.out.println("moving");

        return Status.SUCCESS;
    }

}
