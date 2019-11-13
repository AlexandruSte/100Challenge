

public class Bud {
    private static long divisorsSum(long n) {
        long sum = 0;
        for(int i = 1; i <= n / 2; i++)
            if(n % i == 0)
                sum += i;
        return sum;
    }
    public static String buddy(long start, long limit) {
        for(long n = start; n <= limit; n++) {
            long sN = divisorsSum(n);
            long sM = n + 1;
            long m = sN - 1;
            if(m < start) continue;
            if(divisorsSum(m) == sM)
                return "(" + n + ", " + m + ")";
        }
        return "Nothing";
    }
}
