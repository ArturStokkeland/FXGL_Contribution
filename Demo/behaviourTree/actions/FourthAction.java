package advanced.behaviourTree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

public class FourthAction extends Action {

    @Override
    public Task.Status execute(Entity entity) {

        System.out.println("Fourth");

        return Task.Status.SUCCESS;
    }

}
