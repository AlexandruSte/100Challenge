public class BinarySearchTree {
    private final static int COUNT = 10;

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    // left < root <= right
    Node root;

    public void insert(int key) {
        root = insertNode(root, key);
    }

    public static Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, key);
        else if (key > root.key)
            root.right = insertNode(root.right, key);
        return root;
    }

    public static Node searchKey(Node root, int key) {
        if (root == null) return null;
        if (root.key == key) {
            System.out.println("Node found, key = " + root.key);
            return root;
        }
        if (key < root.key) return searchKey(root.left, key);
        else return searchKey(root.right, key);
    }

    public static Node findMin(Node root) {
        if(root == null) return null;
        if(root.left == null) {
            System.out.println("Min key is " + root.key);
            return root;
        }
        return findMin(root.left);
    }

    public static Node findMax(Node root) {
        if(root == null) return null;
        if(root.right == null) {
            System.out.println("Max key is " + root.key);
            return root;
        }
        return findMax(root.right);
    }

    public static void preorder(Node bst) {
        if (bst != null) {
            System.out.print(bst.key + " ");
            preorder(bst.left);
            preorder(bst.right);
        }
    }

    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(10);
        bst.insert(3);
        bst.insert(5);
        bst.insert(2);
        bst.insert(15);
        bst.insert(9);
        bst.insert(-3);
        bst.insert(534);

        searchKey(bst.root, 5);
        findMin(bst.root);
        findMax(bst.root);
        preorder(bst.root);
        //print2D(bst.root);


    }
}
