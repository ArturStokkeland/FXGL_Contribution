package advanced.behaviourTree.actions;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

public class FirstAction extends Action {

    @Override
    public Task.Status execute(Entity entity) {

        System.out.println("First");

        return Task.Status.SUCCESS;
    }

}
