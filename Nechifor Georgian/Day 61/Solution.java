//https://leetcode.com/problems/valid-palindrome
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");
        System.out.println(s);
        if (s.equals(new StringBuilder(s).reverse().toString()))
            return true;
        return false;
    }

}
