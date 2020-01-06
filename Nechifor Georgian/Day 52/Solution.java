class Solution {
    //https://leetcode.com/problems/generate-parentheses/
    List<String> ans;
    int limit, len;
    public List<String> generateParenthesis(int n) {
        len = 2*n;
        limit = n;
        ans = new ArrayList<>();

        backTrack("(", 1, 0);
        return ans;
    }
    private void backTrack(String s, int l, int r) {
        if(l > limit || r > limit || r > l || s.length() > len) {
            return;
        }

        if(s.length() == len) {
            ans.add(s);
            return;
        }
        backTrack(s+"(", l+1, r);
        backTrack(s+")", l, r+1);
    }
}
