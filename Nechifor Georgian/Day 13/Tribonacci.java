import java.util.Arrays;
public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
        double[] temp = new double[n];
        if(n == 0) return temp;
        temp = Arrays.copyOf(s, n);
        for(int i = 3; i < n; i++) {
            temp[i] = temp[i-3] + temp[i-2] + temp[i - 1];
        }
        return temp;
    }
}