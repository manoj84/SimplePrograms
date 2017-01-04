package interviewCake;

import tree.core.BSTNode;
import trees.execute.TreeUtil;

import java.util.*;

/**
 * Created by mmandam on 1/4/17.
 */
public class PathBetweenNodes {

    public static void main (String args[]) {
        BSTNode<Integer, String > node = TreeUtil.getBinarySearchTree();

        Stack<Integer> path = new Stack<>();
        PathBetweenNodes.compute(node, 4, path);

        System.out.println(path);

    }

    private static boolean compute(BSTNode<Integer, String> node, int i, Stack<Integer> path) {

        if(node == null) {
            return false;
        }

        if(node.key().equals(i)) {
            path.add(i);
            return true;
        }

        path.add(node.key());

        boolean leftFound = compute(node.left(), i, path);

        boolean rightFound = compute(node.right(), i, path);

        boolean found = leftFound || rightFound;

        if(!found) {
            path.pop();
        }

        return found;

    }
}
