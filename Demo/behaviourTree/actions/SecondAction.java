package advanced.behaviourTree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

public class SecondAction extends Action {

    @Override
    public Task.Status execute(Entity entity) {

        System.out.println("Second");

        return Task.Status.SUCCESS;
    }

}
