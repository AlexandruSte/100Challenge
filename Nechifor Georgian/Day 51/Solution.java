//https://leetcode.com/problems/group-anagrams
class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
        int[] freq = new int[strs.length];
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (freq[i] != 1) {
                List<String> aux = new ArrayList<>();
                aux.add(strs[i]);
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String iAux = String.valueOf(chars);
                for (int j = i + 1; j < strs.length; j++) {
                    if (freq[j] != 1) {
                        if (strs[i].length() == strs[j].length()) {
                            char[] charsAux = strs[j].toCharArray();
                            Arrays.sort(charsAux);
                            String jAux = String.valueOf(charsAux);
                            if (iAux.equals(jAux)) {
                                aux.add(strs[j]);
                                freq[j] = 1;
                            }
                        }
                    }
                }
                list.add(aux);
                freq[i] = 1;
            }
        }
        return list;
    }

}
