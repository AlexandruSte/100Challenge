//https://leetcode.com/problems/length-of-last-word/

class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split("\\s+");
        if(strs.length == 0) return 0;
        return strs[strs.length - 1].length();
    }
}
