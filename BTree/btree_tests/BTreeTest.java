package com.almasb.fxgl.pathfinding.btree;

import com.almasb.fxgl.btree.Action;
import com.almasb.fxgl.btree.BehaviourTree;
import com.almasb.fxgl.btree.actions.Selector;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BTreeTest {

    @Test
    public void testValidity() {

        List<String> tree1 = new ArrayList<String>();
        tree1.add("  Sequence");
        List<String> tree2 = new ArrayList<String>();
        tree2.add("Selctor");
        List<String> tree3 = new ArrayList<String>();
        tree3.add("RandomDecoratorThatDoesNotExist:Selector");

        assertThrows(IllegalArgumentException.class, () -> {
            new BehaviourTree(tree1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new BehaviourTree(tree2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new BehaviourTree(tree3);
        });

    }

    @Test
    public void testFunctionality() {

        List<String> tree1 = new ArrayList<String>();
        tree1.add("Selector");

        BehaviourTree myTree = new BehaviourTree(tree1);

        Entity enemy = new Entity();
        enemy.addComponent(myTree);

        Component myComponent = enemy.getComponent(BehaviourTree.class);
        assert(myComponent instanceof BehaviourTree);
        Action myAction = ((BehaviourTree) myComponent).getRootNode().getAction();
        assert(myAction instanceof Selector);

    }

    @Test
    public void testTree1() {

        List<String> tree1 = new ArrayList<String>();
        tree1.add("Selector");
        tree1.add("    Sequence");
        tree1.add("        com.almasb.fxgl.pathfinding.btree.actions.AssertTrue");
        tree1.add("        com.almasb.fxgl.pathfinding.btree.actions.AssertTrue");
        tree1.add("        Inverter");
        tree1.add("            com.almasb.fxgl.pathfinding.btree.actions.AssertTrue");
        tree1.add("        com.almasb.fxgl.pathfinding.btree.actions.AssertFalse");

        BehaviourTree myTree = new BehaviourTree(tree1);
        myTree.getRootNode().evaluate(null);

    }

    @Test
    public void testTree2() {

        List<String> tree1 = new ArrayList<String>();
        tree1.add("Selector");
        tree1.add("    AlwaysFail");
        tree1.add("        com.almasb.fxgl.pathfinding.btree.actions.AssertTrue");
        tree1.add("    Sequence");
        tree1.add("        Inverter");
        tree1.add("            AlwaysSucceed");
        tree1.add("                com.almasb.fxgl.pathfinding.btree.actions.AssertTrue");
        tree1.add("        com.almasb.fxgl.pathfinding.btree.actions.AssertFalse");

        BehaviourTree myTree = new BehaviourTree(tree1);
        myTree.getRootNode().evaluate(null);

    }

}
