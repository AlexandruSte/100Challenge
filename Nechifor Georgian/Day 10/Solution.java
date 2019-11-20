class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value) {
        this(value, null, null);
    }

    TreeNode() {
        super();
    }

    @Override
    public boolean equals(Object other) {
        TreeNode nod = (TreeNode) other;
        if(other instanceof TreeNode)
            if(nod.value == this.value) {
                if(nod.left.equals(this.left)) {
                    if(nod.right.equals(this.right))
                        return true;
            }
        }
        return false;
    }
}

public class Solution {
    static TreeNode treeCreator(int[] array, TreeNode root, int i) {
        if(i < array.length) {
            TreeNode temp = new TreeNode(array[i]);
            root = temp;

            root.left = treeCreator(array, root.left, 2 * i + 1);
            root.right = treeCreator(array, root.left, 2 * i + 2);
        }

        return root;
    }
    static TreeNode arrayToTree(int[] array) {
        if(array.length == 0) return null;
        TreeNode root = new TreeNode();
        root = treeCreator(array, root, 0);
        return root;
    }
