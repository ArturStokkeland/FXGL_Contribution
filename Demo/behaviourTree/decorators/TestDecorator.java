package advanced.behaviourTree.decorators;

import com.almasb.fxgl.btree.Decorator;
import com.almasb.fxgl.btree.Task;
import com.almasb.fxgl.entity.Entity;

public class TestDecorator extends Decorator {

    public TestDecorator() {
        System.out.println("TestDecorator created");
    }

    @Override
    public Task.Status evaluate(Entity entity) {

        return Task.Status.SUCCESS;

    }

}
