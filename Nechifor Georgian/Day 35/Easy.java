//https://leetcode.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
        while (k != 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    private TreeNode buildBST(int[] arr, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildBST(arr, l, mid - 1);
        root.right = buildBST(arr, mid + 1, r);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    //https://leetcode.com/problems/isomorphic-strings/
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;
        int[] sl = new int[256];
        int[] tl = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            int b = t.charAt(i);
            int c = sl[a];
            int d = tl[b];
            if (c == 0 && d == 0) {
                sl[a] = b;
                tl[b] = a;
            } else if (c != 0 && b != c)
                return false;
            else if (d != a)
                return false;
        }
        return true;

    }
