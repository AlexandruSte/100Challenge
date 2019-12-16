//https://leetcode.com/problems/n-ary-tree-preorder-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> pre = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) 
            return pre;
        
        pre.add(root.val);
        
        if(root.children != null) {
            for(Node i: root.children) {
                preorder(i);
            }
        }
        return pre;
    }
    
    //https://leetcode.com/problems/reverse-words-in-a-string-iii/
    public String reverseWords(String s) {
        String[] sAux = s.split("\\s+");
        StringBuilder ret = new StringBuilder();
        for (String sx : sAux) {
            ret.append(new StringBuilder(sx).reverse().toString() + " ");
        }
        return ret.toString().trim();
    }
    //https://leetcode.com/problems/can-place-flowers/
    public boolean canPlaceFlowers(int[] arr, int n) {
        if(n == 0) return true;
        if(arr.length == 1) {
            if(arr[0] == 0)
                return true;
            else
                return false;
        }
        for(int i = 0; i < arr.length; i++) {
            if(n == 0) return true;
            if(i == 0 && arr[i] == 0 && arr[1] != 1) {
                n--;
                arr[i] = 1;
            }
            else if(i == arr.length - 1 && arr[i] == 0 && arr[i - 1] != 1) {
                n--;
                arr[i] = 1;
            }
            else if(i < arr.length - 1 && arr[i] == 0 && (arr[i+1] != 1 && arr[i-1] != 1)) {
                n--;
                arr[i] = 1;
            }
        }
        
        if(n != 0)
            return false;
        return true;
    }
}


