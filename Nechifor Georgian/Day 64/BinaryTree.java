import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {
    static final int COUNT = 10;
    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    Node root;

    /**
     * ********** OPERATII ***********
     * parcurgere / traversare arbore
     * *** Preorder
     * *** Inorder
     * *** Postorder
     * inserare nod in arbore
     * stergere nod din arbore
     **/

    /* creare arbore din vector */
    public static Node createBinaryTree(List<Integer> v) {
        if (v.size() == 0) return null;
        int c = v.get(0);
        v.remove(0);
        if (c == 0) return null;
        Node root = new Node(c);

        root.left = createBinaryTree(v);
        root.right = createBinaryTree(v);

        return root;
    }

    public static Node createBalancedBinaryTree(List<Integer> v, int n) {
        Node root;
        int nLeft, nRight;
        if(n <= 0) return null;
        nLeft = n / 2;
        nRight = n - nLeft - 1;
        root = new Node(v.get(0));
        v.remove(0);
        root.left = createBalancedBinaryTree(v, nLeft);
        root.right = createBalancedBinaryTree(v, nRight);

        return root;
    }

    public static void preorder(Node tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preorder(tree.left);
            preorder(tree.right);
        }
    }

    public static void postorder(Node tree) {
        if (tree != null) {
            postorder(tree.left);
            postorder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public static void inorder(Node tree) {
        if (tree != null) {
            inorder(tree.left);
            System.out.print(tree.key + " ");
            inorder(tree.right);
        }
    }

    public static int leafNodes(Node tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) {
            System.out.print(tree.key + " ");
            return 1;
        }
        return leafNodes(tree.left) + leafNodes(tree.right);
    }

    public static int internNodes(Node tree) {
        if (tree == null) return 0;
        if(tree.left != null || tree.right != null) {
            System.out.print(tree.key + " ");
            return 1 + internNodes(tree.left) + internNodes(tree.right);
        }
        return 0;
    }

    public static int height(Node tree) {
        if(tree == null) return -1;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    public static Node search(Node tree, int key) {
        if(tree == null) return null;
        if(tree.key == key) {
            System.out.println("Inatimea nodului cautat: " + height(tree));
            return tree;
        }
        Node found = search(tree.left, key);
        if(found == null)
            found = search(tree.right, key);
        return found;
    }


    static void print2DUtil(Node root, int space)
    {
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
    static void print2D(Node root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }


    public static void main(String[] args) {
        /*List<Integer> v = new ArrayList<>(Arrays.asList(1, 7, 2, 0, 5, 0, 0, 0, 9, 3, 0, 0, 4, 0, 6, 0, 0));
        BinaryTree tree = new BinaryTree();
        tree.root = createBinaryTree(v);*/

        List<Integer> v = new ArrayList<>(Arrays.asList(1, 7, 2, 5, 9, 3, 4, 6));
        BinaryTree tree = new BinaryTree();
        tree.root = createBalancedBinaryTree(v, v.size());

        preorder(tree.root);
        System.out.println();
        print2D(tree.root);
/*

        System.out.println("Leaf nodes: ");
        System.out.println("\nNumber of leaf nodes: " + leafNodes(tree.root));

        System.out.println("Intern nodes: ");
        System.out.println("\nNumber of intern nodes: " + internNodes(tree.root));

        System.out.println("Inaltime arbore: " + height(tree.root));
*/

//        Node search = search(tree.root, 413);
//        if(search == null)
//            System.out.println("Node not found");
//        else
//            System.out.println("Node found: " + search.key);
    }
}
