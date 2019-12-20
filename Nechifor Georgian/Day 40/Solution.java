//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

class Solution {
   public int countCharacters(String[] words, String chars) {
        int[] aux = new int[256];
        int[] word = new int[256];
        for(int i = 0; i < chars.length(); i++) {
            aux[chars.charAt(i)]++;
        }
        int nr = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                word[words[i].charAt(j)]++;
            }
            int ok = 1;
            for(int x = 0; x < 256; x++) {
                if(word[x] > aux[x])
                    ok = 0;
            }

            if(ok == 1)
                nr += words[i].length();
             word = new int[256];
        }

        return nr;
    }
}
