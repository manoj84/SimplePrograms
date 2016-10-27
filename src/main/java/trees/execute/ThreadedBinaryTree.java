package trees.execute;

import tree.core.BSTNode;

import java.util.Stack;

public class ThreadedBinaryTree {

    private Stack<BSTNode> stack = new Stack<BSTNode>();

    public static void main(String args[]) {
        ThreadedBinaryTree tbTree = new ThreadedBinaryTree();
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        tbTree.convert(node);

    }

    private void convert(BSTNode<Integer, String> node) {
        stack.add(node);

        while (node != null && !stack.isEmpty()) {
            if (node.left() != null) {
                stack.add(node.left());
                node = node.left();
            } else {
                node = stack.pop();

                System.out.println(node);
                if (node.right() != null) {
                    stack.add(node.right());
                    node = node.right();
                } else {
                    if (!stack.isEmpty())
                        node.setRight(stack.peek());
                }
            }
        }

        // At this point test our Threaded binary tree

    }
}
