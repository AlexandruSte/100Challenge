//https://leetcode.com/problems/rotate-image/
class Rotate {
    public void rotate(int[][] matrix) {
        int aux[][] = new int[matrix.length][matrix.length];
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                aux[i][j] = matrix[i][j];
        }

        int k = n - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[j][k] = aux[i][j];
            }
            k--;
        }
    }
}
