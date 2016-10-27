package trees.execute;

import tree.core.BSTNode;

import java.util.Stack;

/**
 * Created by Manoj on 12/26/15.
 */
public class RoundOrder {

    Stack<BSTNode> stack = new Stack();

    public static void main(String args[]) {
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        RoundOrder roundOrder = new RoundOrder();
        roundOrder.compute(node);
    }

    private void compute(BSTNode<Integer, String> node) {
        BSTNode<Integer, String> leftNode = node.left();
        BSTNode<Integer, String> rightNode = node.right();

        //Print the root.
        System.out.println(node.element());


        while (leftNode != null) {
            System.out.println(leftNode.element());
            stack.add(leftNode.right());
            leftNode = leftNode.left();
        }

        while (!stack.isEmpty()) {
            printLeaf(stack.pop());
        }

        while (rightNode != null) {
            stack.add(rightNode);
            printLeaf(rightNode.left());
            rightNode = rightNode.right();
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().element());
        }

    }


    private void printLeaf(BSTNode<Integer, String> node) {
        if (node == null) return;

        if (node.left() == null && node.right() == null) {
            System.out.println(node.element());
        }

        printLeaf(node.left());
        printLeaf(node.right());
    }
}
