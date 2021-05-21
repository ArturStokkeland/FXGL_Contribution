package com.almasb.fxgl.btree;

import com.almasb.fxgl.btree.actions.*;
import com.almasb.fxgl.entity.component.Component;
import java.util.List;
import java.util.Stack;
import java.lang.reflect.*;

public class BehaviourTree extends Component {

    private Node rootNode;

    public BehaviourTree(List<String> treeSettings) {

        Stack<Node> nodeStack = new Stack<Node>();

        int lineNumber = 0;

        for (String mySetting : treeSettings) {

            lineNumber++;

            //find amount of indents
            int spaceCounter = 0;
            while(mySetting.startsWith(" ")) {
                spaceCounter++;
                mySetting = mySetting.substring(1);
            }

            //pop until indent amount has been reached
            if (spaceCounter % 4 != 0) {
                throw new IllegalArgumentException("Wrong amount of indentation on line " + lineNumber);
            }
            while(nodeStack.size() > spaceCounter / 4) {
                nodeStack.pop();
            }

            //create new node
            String[] mySettings = mySetting.split(":");

            Decorator myDecorator = null;
            Action myAction = null;
            Node myNode = null;
            if (mySettings.length <= 0) {
                return;
            }
            else if (mySettings.length == 1) {
                myAction = createAction(mySettings[0], lineNumber);
                myNode = new Node(myAction);
            }
            else {
                try {
                    Class<?> myDecoratorClass = Class.forName(mySettings[0]);
                    myDecorator = (Decorator) myDecoratorClass.getDeclaredConstructor().newInstance();
                }
                catch (Throwable e) {
                    throw new IllegalArgumentException("Could not find class '" + mySettings[0] + "' on line " + lineNumber);
                }
                myAction = createAction(mySettings[1], lineNumber);
                myNode = new Node(myDecorator, myAction);
            }

            //add node as child of node on top of stack
            if (nodeStack.size() == 0) {
                rootNode = myNode;
            }
            else {
                nodeStack.peek().getAction().addChild(myNode);
            }

            //push node to stack
            nodeStack.push(myNode);

        }

    }

    private Action createAction(String action, int lineNumber) {

        Action myAction = null;

        switch (action) {
            case "Selector":
                myAction = new Selector();
                break;
            case "Sequence":
                myAction = new Sequence();
                break;
            case "Inverter":
                myAction = new Inverter();
                break;
            case "AlwaysSucceed":
                myAction = new AlwaysSucceed();
                break;
            case "AlwaysFail":
                myAction = new AlwaysFail();
                break;
            default:
                try {
                    Class<?> myActionClass = Class.forName(action);
                    myAction = (Action) myActionClass.getDeclaredConstructor().newInstance();
                }
                catch (Throwable e) {
                    throw new IllegalArgumentException("Could not find class '" + action + "' on line " + lineNumber);
                }
                break;
        }

        return myAction;

    }

    @Override
    public void onUpdate(double tpf) {
        rootNode.evaluate(entity);
    }

    public Node getRootNode() {
        return rootNode;
    }

}
