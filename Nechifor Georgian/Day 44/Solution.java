//https://leetcode.com/problems/reverse-words-in-a-string
class Solution {
     public String reverseWords(String s) {
        String[] aux = s.split("\\s+");
        StringBuilder temp = new StringBuilder();
        for(int i = aux.length - 1; i >= 0; i--) {
            temp.append(aux[i]);
            temp.append(" ");
        }

        return temp.toString().trim();
    }
}
