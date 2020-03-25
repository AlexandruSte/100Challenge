import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem {

    public void nume() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.next();

            char[] chars = str[i].toCharArray();
            chars[0] += 32;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] < 'a') {
                    chars[j - 1] -= 32;
                    chars[j] += 32;
                }
            }
            if (chars[chars.length - 1] >= 'a')
                chars[chars.length - 1] -= 32;
            str[i] = new StringBuilder(String.copyValueOf(chars)).reverse().toString();
        }

        for (int i = 0; i < n; i++)
            System.out.println(str[i]);
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public void sediu() {
        Scanner in = new Scanner(System.in);
        int n, m, k, xInit, yInit;
        n = in.nextInt();
        m = in.nextInt();
        xInit = in.nextInt();
        yInit = in.nextInt();
        k = in.nextInt();

        int[][] v = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v[i][j] = in.nextInt();
            }
        }
        int distMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (Math.abs(i - xInit) <= k) { //daca linia curenta e prea departe, nu o mai verificam
                for (int j = 0; j < m; j++) {
                    if (Math.abs(j - yInit) <= k) { //daca coloana curenta e prea departe, nu o mai verificam
                        if (v[i][j] > 0) {
                            int dist = distance(xInit, yInit, i, j);
                            if (dist <= k) {
                                if (v[i][j] < distMin)
                                    distMin = v[i][j];
                            }
                        }
                    }
                }
            }
        }

        System.out.println(distMin);
    }

    static List<Integer> component = new ArrayList<>();
    static int comp = 0;

    private static boolean isSafe(int[][] v, int x, int y, boolean[][] visited) {
        int n = v.length;
        int m = v[0].length;
        return (x >= 0) && (x < n) && (y >= 0) && (y < m) && (v[x][y] == 1 && !visited[x][y]);
    }

    private static void componentsUtil(int[][] m, int x, int y, boolean[][] visited) {
        int[] rows = new int[]{-1, 0, 0, 1};
        int[] cols = new int[]{0, -1, 1, 0};
        comp++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (isSafe(m, x + rows[i], y + cols[i], visited)) {
                componentsUtil(m, x + rows[i], y + cols[i], visited);
            }
        }
    }

    private static void connectedComponents(int[][] adjList, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                visited[i][j] = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (adjList[i][j] == 1 && !visited[i][j]) {
                    comp = 0;
                    componentsUtil(adjList, i, j, visited);
                    component.add(comp);
                }
            }
        }
    }

    public void camere() {
        Scanner in = new Scanner(System.in);
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
//        int[][] v = new int[n][m];
        int[][] adjList = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = in.nextInt();
//                v[i][j] = val;
                if (val == 0)
                    adjList[i][j] = 1;
            }
        }

        connectedComponents(adjList, n, m);

        component.sort(Integer::compareTo);
        System.out.println(component.size());
        for (Integer i : component)
            System.out.print(i + " ");
    }

    public boolean valid(char[][] m, int x, int y) {
        return (x < m.length) && (x >= 0) && (y >= 0) && (y < m[0].length);
    }
    List<String> values = new ArrayList<>();
    public void back(char[][] m, int k, int x, int y, int size, char[] v) {
        if (size == k) {
            values.add(String.valueOf(v));
        } else {
            int[] rows = new int[]{0};
            int[] cols = new int[]{0};
            if(size > 0) {
                rows = new int[]{0, -1, 0, 0, 1};
                cols = new int[]{0, 0, -1, 1, 0};
            }

            for (int i = 0; i < rows.length; i++) {
                if (valid(m, x + rows[i], y + cols[i])) {
                    v[size] = m[x + rows[i]][y + cols[i]];
                    back(m, k, x + rows[i], y + cols[i], size + 1, v);
                }
            }
        }
    }

    public static void backt(char[][] matrix, int line, int col, String solution, int k, int poss){
        if(solution.length() == k){
            System.out.println(solution);
        }
        else{
            List<Character> possibilities = new ArrayList<>();
            possibilities.add((char) matrix[line][col]);
            if(poss > 0) {
                if (line + 1 < matrix.length)
                    possibilities.add((char) matrix[line + 1][col]);
                if (col + 1 < matrix.length)
                    possibilities.add((char) matrix[line][col + 1]);
                if (line - 1 >= 0)
                    possibilities.add((char) matrix[line - 1][col]);
                if (col - 1 >= 0)
                    possibilities.add((char) matrix[line][col - 1]);
            }
            for(char pos : possibilities){
                solution += pos;
                backt(matrix, line, col, solution, k, poss + 1);
                solution = solution.substring(0, solution.length() - 1);
            }
        }
    }

    public void parola() {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();

        int x = 0, y = 1, k = 4;
        char[][] key = new char[][] {{'B', 'X'}};


        char[] v = new char[k];
        //backt(key, x, y, "", 4, 0);
        back(key, k, x, y, 0, v);

        values.sort(String::compareTo);
        System.out.println(values);

    }

    public void limonada() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            c[i] = in.nextInt();

        Arrays.sort(c);
        int min = c[0];
        List<Integer> divisors = new ArrayList<>();
        divisors.add(min);
        for (int x = 2; x <= (int) Math.sqrt(min); x++) {
            if (min % x == 0) {
                divisors.add(x);
                if (min / x != x)
                    divisors.add(min / x);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < divisors.size(); k++) {
                if (c[i] % divisors.get(k) != 0) {
                    divisors.remove(divisors.get(k));
                }
            }
            if (divisors.size() == 0)
                break;
        }

        System.out.println(divisors.size() + 1);
    }


    public static void main(String[] args) {
        Problem p = new Problem();
        p.parola();
    }


}
