public class Easy {

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
    static class KthLargest {
        List<Integer> nums = new ArrayList<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++)
                this.nums.add(nums[i]);
        }

        public int add(int val) {
            System.out.println(nums);
            this.nums.add(val);
            nums.sort(Collections.reverseOrder());
            return nums.get(this.k - 1);
        }
    }

    //https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    //https://leetcode.com/problems/merge-two-binary-trees/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            if (t2 != null)
                return t2;
            return null;
        }
        if(t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    //https://leetcode.com/problems/subtree-of-another-tree/
    private boolean isEquals(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null ||  t == null)
            return false;
        return (s.val == t.val) && isEquals(s.left, t.left) && isEquals(s.right, t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null)
            return true;
        if(s == null)
            return false;

        if(isEquals(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

}
