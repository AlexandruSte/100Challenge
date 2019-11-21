#https://www.codewars.com/kata/battle-ships-sunk-damaged-or-not-touched/java

import java.util.*;

public class BattleShips {

    private static int[] count(int[][] board) {
        int[] ret = new int[4];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                ret[board[i][j]]++;
            }
        }
        return ret;
    }

    public static Map<String,Double> damagedOrSunk(final int[][] board, final int[][] attacks) {
        // Your code here..
        Map<String, Double> rez = new HashMap<>();
        rez.put("sunk", 0.0);
        rez.put("damaged", 0.0);
        rez.put("notTouched", 0.0);
        rez.put("points", 0.0);

        double points = 0.0;
        int[] count = count(board);
        int one = count[1], oneStart = count[1];
        int two = count[2], twoStart = count[2];
        int three =  count[3], threeStart = count[3];
        //System.out.println(one + " " + two + " " + three);
        int n = board.length;
        //System.out.println(n);
        for(int i = 0; i < attacks.length; i++) {
            //System.out.println((attacks[i][0]-1) + " " + attacks[i][1]);
            int y = attacks[i][0] - 1;
            int x = n - (attacks[i][1]);
            int ship = board[x][y];
            //System.out.println(x + " " + y + " SHIP: " + ship);
            if(ship != 0) {
                switch (ship) {
                    case 1:
                        if(one > 0)
                            one--;
                        break;
                    case 2:
                        if(two > 0)
                            two--;
                        break;
                    case 3:
                        if(three > 0)
                            three--;
                        break;
                }
            }
        }
        //System.out.println("Remaining: " + one + " " + two + " " + three);
        if(one == 0 && oneStart != 0) {
            points += 1;
            rez.put("sunk", rez.get("sunk") + 1);
        }
        else if(oneStart != 0 && oneStart != one){
            rez.put("damaged", rez.get("damaged") + 1.0);
            points += 0.5;
        }

        if(two == 0 && twoStart != 0) {
            points += 1.0;
            rez.put("sunk", rez.get("sunk") + 1);
        }
        else if(twoStart != 0 && twoStart != two){
            rez.put("damaged", rez.get("damaged") + 1.0);
            points += 0.5;
        }

        if(three == 0 && threeStart != 0) {
            points += 1;
            rez.put("sunk", rez.get("sunk") + 1);
        }
        else if(threeStart != 0 && three != threeStart){
            rez.put("damaged", rez.get("damaged") + 1);
            points += 0.5;
        }

        if(one == count[1] && count[1] != 0) {
            rez.put("notTouched", rez.get("notTouched") + 1);
            points -= 1;
        }

        if(two == count[2] && count[2] != 0) {
            rez.put("notTouched", rez.get("notTouched") + 1);
            points -= 1;
        }

        if(three == count[3] && count[3] != 0) {
            rez.put("notTouched", rez.get("notTouched") + 1);
            points -= 1;
        }

        rez.put("points", points);

        return rez;
    }

    public static void main(String[] args) {
        int[][] board   = new int[][] {
                new int[] {3, 0, 1},
                new int[] {3, 0, 1},
                new int[] {0, 2, 1},
                new int[] {0, 2, 0}};
        int[][] attacks = new int[][] {new int[] {2,1},new int[] {2,2},new int[] {3,2},new int[] {3,3}};


        Map<String,Double> expected = new HashMap<String,Double>();

        expected = damagedOrSunk(board, attacks);
        System.out.println(expected);
    }
}
