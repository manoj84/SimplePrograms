/**
 * Create a linked list for each level of binary tree.
 */

package trees.execute;

import tree.core.BSTNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EachLevelArrayForBinaryTree {

    public static void main(String args[]) {
        BSTNode<Integer, String> root = TreeUtil.getBinarySearchTree();
        EachLevelArrayForBinaryTree tree = new EachLevelArrayForBinaryTree();
        tree.inOrder(root);
        List<LinkedList<BSTNode>> list = tree.constructArrayAtEachLevels(root);

    }

    private List<LinkedList<BSTNode>> constructArrayAtEachLevels(
            BSTNode<Integer, String> root) {
        LinkedList<BSTNode> parentQueue = new LinkedList<BSTNode>();
        LinkedList<BSTNode> childQueue = new LinkedList<BSTNode>();
        parentQueue.add(root);
        List<LinkedList<BSTNode>> results = new ArrayList<LinkedList<BSTNode>>();

        Iterator<BSTNode> iterator = parentQueue.iterator();

        while (iterator.hasNext()) {
            BSTNode node = iterator.next();
            childQueue.add(node.left());
            childQueue.add(node.right());

            if (!iterator.hasNext()) {
                results.add(parentQueue);
                parentQueue = childQueue;
                iterator = parentQueue.iterator();
            }
        }

        return results;
    }

    private void inOrder(BSTNode<Integer, String> root) {
        if (root == null)
            return;

        inOrder(root.left());
        System.out.print(root.key());
        inOrder(root.right());
    }
}
