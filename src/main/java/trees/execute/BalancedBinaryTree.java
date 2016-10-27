package trees.execute;

import tree.core.BSTNode;

public class BalancedBinaryTree {

    public static void main(String args[]) {
        BSTNode<Integer, String> node = TreeUtil.getBinarySearchTree();
        BSTNode<Integer, String> node1 = TreeUtil.getUnBalancedTree();
        // checkBalance(node, 0);
        checkBalance(node1, 0);

    }

    private static int checkBalance(BSTNode<Integer, String> node, int height) {
        if (node == null)
            return height;

        else {
            int leftHeght = checkBalance(node.left(), height);
            int rightHeight = checkBalance(node.right(), height);
            if (leftHeght - rightHeight > 1) {
                System.out.println("Tree is not balanced");
            }

            return (Math.max(leftHeght, rightHeight) + 1);

        }

    }

}
