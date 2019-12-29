 //https://leetcode.com/problems/trim-a-binary-search-tree/

    public TreeNode trimBST(TreeNode root, int L, int R) {
      if(root == null)
          return null;

      root.left = trimBST(root.left, L, R);
      root.right = trimBST(root.right, L, R);

      if(root.val < L) {
          TreeNode aux = root.right;
          root = null;
          return aux;
      }
      if(root.val > R) {
          TreeNode aux = root.left;
          root = null;
          return aux;
      }
      return root;
    }
