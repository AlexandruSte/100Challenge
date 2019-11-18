class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        // your code
        String max = "";
        String aux = "";
        int len = strarr.length;
        for(int i = 0; i <= len - k; i++) {
            for(int j = i; j < i+k; j++) {
                aux += strarr[j];
                if(aux.length() > max.length()) {
                    max = aux;
                }
            }
            aux = "";
        }
        return max;
    }
