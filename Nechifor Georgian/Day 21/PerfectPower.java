import java.util.Arrays;

public class PerfectPower {

    private static int[] simplify(int n) {
        for(int i = 2; i <= n; i++) {
            for(int j = 2; Math.pow(j, i) <= n; j++) {
                if(Math.pow(j, i) == n)
                    return new int[]{j, i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(simplify(216)));
    }
}
