//https://leetcode.com/problems/longest-common-prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());
        String s = strs[0];
        String ret = "";

        for(int k = 0; k < s.length(); k++) {
            int ok = 1;
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length() <= k)
                    return ret;
                if (strs[i].charAt(k) != s.charAt(k)) {
                    ok = 0;
                }
            }
            if(ok == 1)
                ret += s.charAt(k);
            else
                break;
        }

        return ret;
    }
}
