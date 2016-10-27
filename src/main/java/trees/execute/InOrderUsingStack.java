package trees.execute;

import tree.core.BSTNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InOrderUsingStack {

    private Stack<BSTNode> stack = new Stack<BSTNode>();

    public static void main(String args[]) {
        InOrderUsingStack stack = new InOrderUsingStack();
        System.out.println("Printing In Order");
        stack.inOrder();

        System.out.println("Printing Pre Order");
        stack.preOrder();

        System.out.println("Priting Level Order");
        stack.levelOrder();

    }

    private void preOrder() {
        stack.clear();
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();

        stack.add(node);

        while (!stack.isEmpty()) {
            BSTNode<Integer, String> node1 = (stack).pop();
            System.out.println(node1);
            if (node1.right() != null)
                stack.add(node1.right());
            if (node1.left() != null)
                stack.add(node1.left());

        }

    }

    private void inOrder() {
        stack.clear();
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left();
            } else {
                node = stack.pop();
                System.out.println(node);
                node = node.right();
            }
        }
    }

    /**
     * Level order done with queues.
     */
    public void levelOrder() {
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        Queue<BSTNode> queue = new LinkedList<BSTNode>();
        queue.add(node);

        while (node != null || !queue.isEmpty()) {
            BSTNode<Integer, String> pop = queue.poll();
            if (pop.left() != null)
                queue.add(pop.left());
            if (pop.right() != null)
                queue.add(pop.right());
            System.out.println(pop);
        }

    }
}
