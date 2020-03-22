public class Backtracking {

    private void afisare(int[] v, int m) {
        for (int i = 0; i < m; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    //permutari
    public void back(int[] v, int k, int n) {
        for (int i = 1; i <= n; i++) {
            v[k] = i;
            //verificare
            boolean ok = true;
            for (int j = 0; j < k; j++) {
                if (v[j] == v[k]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                afisare(v, n);
                if (k == n - 1) {
                    System.out.print("SOLUTIE: ");
                    afisare(v, n);
                } else
                    back(v, k + 1, n);
            }
        }
    }

    //combinari
    public void back_0(int[] v, int k, int n, int m) {
        for (int i = 1; i <= n; i++) {
            v[k] = i;
            boolean ok = true;
            for (int j = 0; j < k; j++) {
                if (v[j] >= v[k]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                if (k == m - 1) {
                    afisare(v, m);
                } else
                    back_0(v, k + 1, n, m);
            }
        }
    }


    //queens problem
    public void printQueens(char[][] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public boolean validare(char[][] v, int line, int col) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                //line validation
                if (i == line && j != col) {
                    if (v[i][j] == 'R')
                        return false;
                }
                //column validation
                if (j == col && i != line) {
                    if (v[i][j] == 'R')
                        return false;
                }
                //diagonal validation
                if (i != line && j != col) {
                    if (v[i][j] == 'R') {
                        int deltaRow = Math.abs(line - i);
                        int deltaCol = Math.abs(col - j);
                        if (deltaCol == deltaRow)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public void back_1(char[][] v, int k, int n) {
        if (k == n) {
            printQueens(v);
        } else {
            for (int i = 0; i < n; i++) {
                v[k][i] = 'R';
                if (validare(v, k, i)) {
                    back_1(v, k + 1, n);
                }
                v[k][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Backtracking back = new Backtracking();
        int n = 4;
//        back.back(v, 0, n);

        int[] v = new int[5];
        //back.back_0(v, 0, 5, 4);

        char[][] queens = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                queens[i][j] = '.';
        }
        //back.back_1(queens, 0, n);
        
    }
}
