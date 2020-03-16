//https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
     public int lengthOfLongestSubstring(String s) {
        if (s == "" || s.length() == 0)
            return 0;
        Set<Character> chrs = new HashSet<>();
        char[] ca = s.toCharArray();
        StringBuilder s0 = new StringBuilder();
        int  count = 0;
        int max = 0;
        for (int i = 0; i < ca.length; i++) {
            if (!chrs.add(ca[i])) {
                while (!chrs.add(ca[i])) {
                    chrs.remove(ca[count]);
                    count++;
                }
            }
            max = Math.max(max, i-count);
        }
        return ++max;
    }
}
