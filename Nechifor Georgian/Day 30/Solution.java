class Solution {
   public boolean validLine(char[] line) {
        int[] v = new int[10];
        for (char c : line) {
            int idx = (c - '0');
            if (c != '.')
                v[idx]++;
        }

        for (int value : v)
            if (value > 1)
                return false;
        return true;
    }

    public boolean validColumn(char[][] line, int n) {
        int[] v = new int[10];
        for (int i = 0; i < line[0].length; i++) {
            int idx = line[i][n] - '0';
            if (line[i][n] != '.') {
                v[idx]++;
            }
        }
        for (int value : v)
            if (value > 1)
                return false;
        return true;
    }

    public boolean validSquare(char[][] board, int sR, int sC) {
        int[] v = new int[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i + sR][j + sC];
                if(c != '.') {
                    int idx = c - '0';
                    v[idx]++;
                }
            }
        }
        for (int value : v)
            if (value > 1)
                return false;
        return true;

    }

    public boolean isValidSudoku(char[][] board) {
        int ok = 1;
        for (int i = 0; i < board.length; i++) {
            if (!validLine(board[i]))
                ok = 0;
        }
        for (int i = 0; i < board.length; i++) {
            if (!validColumn(board, i))
                ok = 0;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3)
                if (!validSquare(board, i, j))
                    ok = 0;
        }
        return ok == 1;
    }
}
