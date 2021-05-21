package advanced.behaviourTree;
import com.almasb.fxgl.btree.BehaviourTree;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class BehaviourTreeSample extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(600);
        settings.setHeight(600);
        settings.setTitle("Behaviour Tree Sample");
        settings.setVersion("1.0");
    }

    public enum EntityType {
        PLAYER;
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5); // move right 5 pixels
        });

        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5); // move left 5 pixels
        });

        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-5); // move up 5 pixels
        });

        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5); // move down 5 pixels
        });
    }

    private Entity player;
    private Entity enemy;
    private BehaviourTree enemyBTree;

    @Override
    protected void initGame() {
        player = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(300, 300)
                .view(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach();

        enemy = FXGL.entityBuilder()
                .at(50, 110)
                .view(new Rectangle(25, 25, Color.RED))
                .buildAndAttach();

        List<String> bTreeSettings = FXGL.getAssetLoader().loadText("MoveAttackTree.txt");
        BehaviourTree enemyBTree = new BehaviourTree(bTreeSettings);
        enemy.addComponent(enemyBTree);

    }

    @Override
    protected void onUpdate(double tpf) {
    }

    public static void main(String[] args) {
        launch(args);
    }

}
