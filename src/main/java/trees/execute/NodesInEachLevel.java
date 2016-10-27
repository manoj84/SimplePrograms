package trees.execute;

import tree.core.BSTNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NodesInEachLevel {

    public static void main(String args[]) {
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        NodesInEachLevel ndl = new NodesInEachLevel();
        ndl.printLevels(node);
    }

    private void printLevels(BSTNode<Integer, String> node) {
        int level = 0;
        int childNumber = 0;
        int grandChildrenNumber = 0;
        Queue<BSTNode<Integer, String>> queue = new LinkedList<BSTNode<Integer, String>>();
        queue.add(node);
        childNumber++;
        level++;

        while (!queue.isEmpty()) {
            if (childNumber == 0) {
                level++;
                childNumber = grandChildrenNumber;
                grandChildrenNumber = 0;
            }

            BSTNode<Integer, String> current = queue.remove();
            childNumber--;

            if (current != null) {
                System.out.println("Level " + level + " " + "Node is "

                        + current.key());
                List<BSTNode<Integer, String>> children = current.getChildren();

                // We have added all the children
                for (BSTNode<Integer, String> child : children) {
                    queue.add(child);
                    grandChildrenNumber++;
                }
            }
        }

    }
}
