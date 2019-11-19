public class Solution{
  public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        String[] rez = new String[moves.length];
        int row = position[0];
        int col = position[1];
        int rowMax = fighters.length - 1;
        int colMax = fighters[0].length - 1;

        for(int i = 0; i < moves.length; i++) {
                switch (moves[i]) {
                    case "up":
                        if( (row - 1) >= 0)
                            rez[i] = fighters[--row][col];
                        else rez[i] = fighters[row][col];
                        break;
                    case "down":
                        if(row + 1 <= rowMax)
                            rez[i] = fighters[++row][col];
                        else
                            rez[i] = fighters[row][col];
                        break;
                    case "left":
                        if(col - 1 >= 0)
                            rez[i] = fighters[row][--col];
                        else {
                            col = colMax;
                            rez[i] = fighters[row][col];
                        }
                        break;
                    case "right":
                        if(col + 1 <= colMax)
                            rez[i] = fighters[row][++col];
                        else {
                            col = 0;
                            rez[i] = fighters[row][col];
                        }
                        break;
                }
            }
        return rez;
    }
}
