class Solution {
     public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(len == 0) return 0;
        if(len > haystack.length()) return -1;
        if(haystack.equals(needle)) return 0;
        for(int i = 0; i <= haystack.length() - len; i++) {
            String s = haystack.substring(i, len + i);
            if(s.equals(needle))
                return i;
        }
        return -1;
    }
}
