//https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public boolean isPalindrom(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    
     public String longestPalindrome(String s) {
        if(isPalindrom(s) || s.length() == 1) return s;
        if(s.length() == 0) return "";
        String pal = "";
        String rev = new StringBuilder(s).reverse().toString();
        int len = rev.length() - 1;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                String aux = s.substring(i, j+1);
                int jj = Math.abs(j - len); //current index in reversed String
                String revAux =  rev.substring(jj, jj + (j - i) + 1); //current substring from reversed String
                if(revAux.equals(aux) && revAux.length() > pal.length()) {
                    pal = revAux;
                }
            }
        }
        return pal;
    }
}
