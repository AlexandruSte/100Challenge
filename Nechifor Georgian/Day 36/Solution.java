//https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/

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
}
