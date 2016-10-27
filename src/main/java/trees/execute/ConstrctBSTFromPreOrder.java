package trees.execute;

import tree.core.BSTNode;

public class ConstrctBSTFromPreOrder {

    public static void main(String args[]) {
        int[] data = {10, 5, 1, 7, 40, 50};

        ConstrctBSTFromPreOrder cbpm = new ConstrctBSTFromPreOrder();

        cbpm.construct(data, null);
    }

    private void construct(int[] data, BSTNode<Integer, String> root) {

        int rootInt = data[0];
        BSTNode<Integer, String> rootNode = new BSTNode<Integer, String>();
        rootNode.setKey(rootInt);

        int rightIndex = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] > rootInt) {
                rightIndex = i;
                break;
            }
        }

    }
}
