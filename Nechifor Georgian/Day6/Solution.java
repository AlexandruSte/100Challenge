class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(n < 0) {
            if(x == 0.00000)
                throw new IllegalArgumentException("");
            return 1 / myPow(x, -n);
        } else {
            double halfPow = myPow(x, n / 2);
            double [] factor = {1, x};
            return factor[n%2] * halfPow * halfPow;
        }
    }

}
