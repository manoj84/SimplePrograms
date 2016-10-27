package trees.execute;

/**
 * ==========================================
 * Binary Tree
 * =================================
 * 6 F
 * 4 B          10 G
 * 2 node4      5 node5        12 node6
 * 1 node7     3 node8             11 node9
 * ======================================
 * Check wiki pedia for in order pre order tree traversal for diagram
 */

import tree.core.BSTNode;

public final class TreeUtil {

    public static BSTNode<Integer, String> getBinarySearchTree() {

        BSTNode<Integer, String> F = new BSTNode<Integer, String>();
        F.setKey(6);
        F.setElement("F");
        BSTNode<Integer, String> B = new BSTNode<Integer, String>();
        B.setKey(4);
        B.setElement("B");
        F.setLeft(B);

        BSTNode<Integer, String> G = new BSTNode<Integer, String>();
        G.setKey(10);
        G.setElement("G");
        F.setRight(G);

        BSTNode<Integer, String> A = new BSTNode<Integer, String>();
        A.setKey(2);
        A.setElement("A");
        B.setLeft(A);

        BSTNode<Integer, String> D = new BSTNode<Integer, String>();
        D.setKey(5);
        D.setElement("D");
        B.setRight(D);

        BSTNode<Integer, String> C = new BSTNode<Integer, String>();
        C.setKey(1);
        C.setElement("C");
        D.setLeft(C);

        BSTNode<Integer, String> E = new BSTNode<Integer, String>();
        E.setKey(3);
        E.setElement("E");
        D.setRight(E);

        BSTNode<Integer, String> I = new BSTNode<Integer, String>();
        I.setKey(10);
        I.setElement("I");
        G.setRight(I);


        BSTNode<Integer, String> H = new BSTNode<Integer, String>();
        H.setKey(11);
        H.setElement("H");
        I.setLeft(H);

        return F;

    }

    public static BSTNode<Integer, String> getUnBalancedTree() {

        BSTNode<Integer, String> root = new BSTNode<Integer, String>();
        root.setKey(6);
        BSTNode<Integer, String> firstLeft = new BSTNode<Integer, String>();
        firstLeft.setKey(3);
        root.setLeft(firstLeft);
        BSTNode<Integer, String> firstRight = new BSTNode<Integer, String>();
        firstRight.setKey(10);
        root.setRight(firstRight);

        BSTNode<Integer, String> secondLeft = new BSTNode<Integer, String>();
        firstLeft.setLeft(secondLeft);
        BSTNode<Integer, String> thirdLeft = new BSTNode<Integer, String>();
        secondLeft.setLeft(thirdLeft);

        return root;

    }

    public static BSTNode<Integer, String> getTwoWayTree() {

        BSTNode<Integer, String> node1 = new BSTNode<Integer, String>();
        node1.setKey(6);
        node1.setElement("F");

        BSTNode<Integer, String> node2 = new BSTNode<Integer, String>();
        node2.setKey(4);
        node2.setElement("B");
        node1.setLeft(node2);
        node2.setParent(node1);

        BSTNode<Integer, String> node3 = new BSTNode<Integer, String>();
        node3.setKey(10);
        node3.setElement("G");
        node1.setRight(node3);
        node3.setParent(node1);

        BSTNode<Integer, String> node4 = new BSTNode<Integer, String>();
        node4.setKey(2);
        node4.setElement("A");
        node2.setLeft(node4);
        node4.setParent(node2);

        BSTNode<Integer, String> node5 = new BSTNode<Integer, String>();
        node5.setParent(node2);
        node5.setKey(5);
        node5.setElement("D");
        node2.setRight(node5);

        BSTNode<Integer, String> node7 = new BSTNode<Integer, String>();
        node7.setKey(1);
        node7.setElement("C");
        node4.setLeft(node7);
        node7.setParent(node4);

        BSTNode<Integer, String> node8 = new BSTNode<Integer, String>();
        node8.setKey(3);
        node8.setElement("C");
        node4.setRight(node8);
        node8.setParent(node4);

        BSTNode<Integer, String> node6 = new BSTNode<Integer, String>();
        node6.setKey(12);
        node6.setElement("I");
        node3.setRight(node6);
        node6.setParent(node3);

        BSTNode<Integer, String> node9 = new BSTNode<Integer, String>();
        node9.setKey(11);
        node9.setElement("E");
        node6.setLeft(node9);
        node9.setParent(node6);

        BSTNode<Integer, String> node10 = new BSTNode<Integer, String>();
        node10.setKey(13);
        node10.setElement("H");
        node6.setRight(node10);
        node10.setParent(node6);

        return node1;

    }

    public static void inOrder(BSTNode<Integer, String> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left());
        System.out.print(node.key() + " ");
        inOrder(node.right());
    }

    public static void main(String args[]) {
        BSTNode<Integer, String> node = getBinarySearchTree();
        inOrder(node);
    }

}
