package trees.execute;

import tree.core.BSTNode;

/**
 * Given values of two nodes in a Binary Search Tree, write a c program to find
 * the Lowest Common Ancestor (LCA). You may assume that both the values exist
 * in the tree.
 *
 * @author manoj
 */
public class LCABinaryNodes {

    public static void main(String args[]) {

        LCABinaryNodes lcbnBinaryNodes = new LCABinaryNodes();
        BSTNode<Integer, String> tree = TreeUtil.getBinarySearchTree();

        BSTNode<Integer, String> node1 = new BSTNode<Integer, String>(6, "");
        BSTNode<Integer, String> node2 = new BSTNode<Integer, String>(13, "");

        System.out.println(lcbnBinaryNodes.findLCA(tree, node1, node2));

    }

    private BSTNode<Integer, String> findLCA(BSTNode<Integer, String> root,
                                             BSTNode<Integer, String> node1, BSTNode<Integer, String> node2) {
        if (root == null) return null;
        if (root.key() == node1.key() || root.key() == node2.key()) {
            //Root is the LCA
            return root;
        }

        BSTNode<Integer, String> nodeLeft = findLCA(root.left(), node1, node2);
        BSTNode<Integer, String> nodeRight = findLCA(root.right(), node1, node2);

        if (nodeLeft != null && nodeRight != null) {
            return root;
        } else if (nodeLeft == null && nodeRight != null) {
            return nodeRight;
        } else if (nodeRight == null && nodeLeft != null) {
            return nodeLeft;
        } else {
            return null;
        }

    }

}
