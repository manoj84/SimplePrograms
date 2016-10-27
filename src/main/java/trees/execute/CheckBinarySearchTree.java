/**
 * Implement a function to check if a tree is binary search tree.
 */

package trees.execute;

import tree.core.BSTNode;

public class CheckBinarySearchTree {

    public static void main(String args[]) {
        BSTNode<Integer, String> root = TreeUtil.getBinarySearchTree();
        System.out.println(checkBinary(root, 0, root.key()));
    }

    private static boolean checkBinary(BSTNode<Integer, String> root,
                                       int leftParent, int righParent) {
        boolean checkBnry = true;
        BSTNode<Integer, String> left = root.left();

        BSTNode<Integer, String> right = root.right();

        if (left != null) {
            if (left.key() > root.key() || left.key() < leftParent) {

                checkBnry = false;
                return checkBnry;
            }
        }

        if (right != null) {
            if (right.key() < root.key() || right.key() > righParent) {
                checkBnry = false;
                return checkBnry;
            }
        }
        if (root.left() != null)
            checkBinary(root.left(), root.key(), root.key());
        if (root.right() != null)
            checkBinary(root.right(), root.key(), root.key());

        return checkBnry;
    }
}
