package trees.execute;

import tree.core.BSTNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerilaizeTree {
    Stack<BSTNode> stack = new Stack<BSTNode>();
    Queue<BSTNode> store = new LinkedList<BSTNode>();

    public static void main(String args[]) {
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        SerilaizeTree stree = new SerilaizeTree();

        stree.preOrder(node);

        stree.deSerialize();
    }

    private void preOrder(BSTNode<Integer, String> node) {
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            store.add(node);
            if (node != null) {
                stack.add(node.right());
                stack.add(node.left());
            }
        }

        System.out.println(store);
    }

    private void deSerialize() {
        BSTNode<Integer, String> node = store.poll();
        recurse(node);

    }

    private BSTNode recurse(BSTNode<Integer, String> node) {
        if (node == null)
            return null;
        BSTNode<Integer, String> nodeLeft = store.poll();
        node.setLeft(nodeLeft);
        recurse(nodeLeft);
        BSTNode<Integer, String> nodeRight = store.poll();
        node.setRight(nodeRight);
        recurse(nodeRight);
        return node;
    }

}
