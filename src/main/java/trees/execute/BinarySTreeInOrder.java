/**
 * Takes an Inorder and constructs a Binary Search tree with minimal Height.
 *
 * @author manoj
 */

package trees.execute;

import tree.core.BSTNode;

public class BinarySTreeInOrder {

    public static void main(String args[]) {

        int[] data = {1, 2, 3, 4, 5, 6};

        BinarySTreeInOrder bTreeInOrder = new BinarySTreeInOrder();
        BSTNode<Integer, String> root = bTreeInOrder.createTree(data, 0,
                data.length);

        inOrder(root);
    }

    private static void inOrder(BSTNode<Integer, String> root) {
        if (root == null)
            return;
        inOrder(root.left());
        System.out.print(root.key());
        inOrder(root.right());

    }

    private BSTNode<Integer, String> createTree(int[] data, int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;

        if (mid > data.length - 1)
            return null;
        BSTNode<Integer, String> root = new BSTNode<Integer, String>();
        root.setKey(data[mid]);
        root.setLeft(createTree(data, start, mid - 1));
        root.setRight(createTree(data, mid + 1, end));
        return root;
    }
}
