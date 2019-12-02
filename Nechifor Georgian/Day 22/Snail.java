import java.util.Arrays;

public class Snail {

   private static String[][] toChar(int[][] matrix) {
        String[][] chr = new String[matrix.length][matrix[0].length];
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                chr[i][j] = Integer.toString(matrix[i][j]);
            }
        }

        return chr;
    }
    public static int[] snail(int[][] array) {
        if(array.length == 0 || array[0].length == 0) 
            return new int[0];
        String[][] aux = toChar(array);
        int size = aux.length * aux[0].length;
        int[] rez = new int[size];
        int row = aux.length;
        int col = aux[0].length;
        int k = 0;
        int fRow = 0, lRow = aux.length - 1;
        int fCol = 0, lCol = aux[0].length - 1;
        while(!aux[row/2][col/2].equals("")) {
            //prima linie
            for(int i = 0; i < col; i++) {
                if((fRow < row) && !aux[fRow][i].equals("")) {
                    rez[k] = Integer.parseInt(aux[fRow][i]);
                    k++;
                    aux[fRow][i] = "";
                }
            }
            fRow++;

            //ultima coloana
            for(int i = 0; i < row; i++) {
                if((lCol > 0) &&!aux[i][lCol].equals("")) {
                    rez[k] = Integer.parseInt(aux[i][lCol]);
                    k++;
                    size--;
                    aux[i][lCol] = "";
                }
            }
            lCol--;

            //ultima linie
            for(int i = col - 1; i >= 0; i--) {
                if((lRow > 0) && !aux[lRow][i].equals("")) {
                    rez[k] = Integer.parseInt(aux[lRow][i]);
                    k++;
                    size--;
                    aux[lRow][i] = "";
                }
            }
            lRow--;

            //prima coloana
            for(int i = row - 1; i >= 0; i--) {
                if((fCol < col) &&!aux[i][fCol].equals("")) {
                    rez[k] = Integer.parseInt(aux[i][fCol]);
                    k++;
                    size--;
                    aux[i][fCol] = "";
                }
            }
            fCol++;
        }
        //System.out.println(Arrays.toString(rez));
        return rez;
    }
}
