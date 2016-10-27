package trees.execute;

import tree.core.BSTNode;

public class OrderTree {

    public static void main(String args[]) {
        BSTNode<Integer, String> tree = TreeUtil.getBinarySearchTree();

        OrderTree orderTree = new OrderTree();
        System.out.println(" In Order is ");
        orderTree.inOrder(tree);
        System.out.println(" Pre Order is ");
        orderTree.preOrder(tree);
        System.out.println(" Post Order is ");
        OrderTree.postOrder(tree);

        System.out.println("Is this Binary Search Tree :");
        orderTree.checkBST(tree, null);

    }

    private static void postOrder(BSTNode<Integer, String> tree) {

        if (tree.left() != null)
            postOrder(tree.left());
        if (tree.right() != null)
            postOrder(tree.right());
        System.out.print(tree.key());

    }

    private void preOrder(BSTNode<Integer, String> tree) {

        if (tree.key() != null)
            System.out.print(tree.key());
        if (tree.left() != null)
            preOrder(tree.left());
        if (tree.right() != null)
            preOrder(tree.right());

    }

    private void inOrder(BSTNode<Integer, String> tree) {
        if (tree.left() != null)
            preOrder(tree.left());
        System.out.println(tree.key());
        if (tree.right() != null)
            preOrder(tree.right());
    }

    private void checkBST(BSTNode<Integer, String> tree, Integer ancestor) {

        if (tree != null) {
            int mid = tree.key();
            int left = 0;
            int right = 0;

            if (tree.left() != null)
                left = tree.left().key();
            if (tree.right() != null)
                right = tree.right().key();

            if ((mid <= left) || (mid > right)) {
                System.out.println("not a binary");
                return;
            }

            // Now check the ancestor on Right Side
            if (ancestor != null && ancestor >= right) {
                System.out.println("Not a Binary");
                return;
            }

            // Now check the ancestor on the left side
            if (ancestor != null && ancestor <= left) {
                System.out.println("Not a Binary ");
                return;
            }

            // Set the ancestor
            ancestor = mid;

            checkBST(tree.left(), ancestor);
            checkBST(tree.right(), ancestor);
        }
    }
}
