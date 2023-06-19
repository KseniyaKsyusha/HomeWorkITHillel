package ua.en.kosse.oksana.hillel.hw16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {

    private TreeNode myRoot;

    public void Tree() {
        myRoot = null;
    }


    public void addNode(int value) {
        TreeNode newNode = new TreeNode();
        newNode.setValue(value);
        if (myRoot == null) {
            myRoot = newNode;
        }
        else {
            TreeNode currentNode = myRoot;
            TreeNode parentNode;
            while (true)
            {
                parentNode = currentNode;
                if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null){
                        parentNode.setLeft(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(myRoot);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                TreeNode temp = (TreeNode) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }

    public void traverseLevelOrder() {
        if (myRoot == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(myRoot);

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.remove();

            System.out.print(" " + node.getValue());

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }

            if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
    }


    @Override
    public String toString() {
        return "TreeUtil{" +
                "myRoot=" + myRoot +
                '}';
    }
}