//https://leetcode.com/problems/merge-intervals/
class Solution {
 public int[][] merge(int[][] v) {
        if (v.length < 2) return v;
        Arrays.sort(v, Comparator.comparingInt(x -> x[0]));
        int k = 0;
        int len = 0;
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i + 1][0] <= v[i][1]) {
                v[i+1][0] = v[i][0];
                v[i+1][1] = Math.max(v[i][1], v[i + 1][1]);
                v[i] = new int[]{-1, -1};
                len++;
            }
        }
        // 1 3 2 6

        k = 0;
        int[][] aux = new int[v.length - len][2];
        for(int i = 0; i < v.length; i++) {
            if(v[i][0] != -1 && v[i][1] != -1) {
                aux[k] = v[i];
                k++;
                len++;
            }
        }

        //aux = Arrays.copyOf(aux, len);
        return aux;
    }

}
