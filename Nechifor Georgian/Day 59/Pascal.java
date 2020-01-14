//https://leetcode.com/problems/pascals-triangle/
class Solution {
    public int combinari(int n, int k) {
        int res = 1;
        for(int i = 0; i < k; i++) {
            res *= (n-i);
            res /= (i+1);
        }

        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();
        if (numRows == 0) return pascal;
        else if (numRows == 1) {
            aux.add(1);
            pascal.add(aux);
            return pascal;
        } else if (numRows == 2) {
            pascal.add(new ArrayList<>(Arrays.asList(1)));
            pascal.add(new ArrayList<>(Arrays.asList(1, 1)));
            return pascal;
        } else {
            pascal.add(new ArrayList<>(Arrays.asList(1)));
            pascal.add(new ArrayList<>(Arrays.asList(1, 1)));
            for(int i = 2; i < numRows; i++) {
                aux = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                    aux.add(combinari(i, j));
                }
                pascal.add(aux);
            }
        }
        return pascal;
    }
}
