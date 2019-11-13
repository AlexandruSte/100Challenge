public class ProperFractions {

    private static long cmmdc(long a, long b) {
        if(b == 0)
            return a;
        return cmmdc(b, a % b);
    }

    private static boolean isPrime(long n) {
        if(n == 2 || n == 1) return true;
        for(long i = 2; i <= Math.sqrt(n);  i++)
            if(n % i == 0) return false;
        return true;
    }

    public static long properFractions(long n) {
        long nr = 1;
        boolean m2 = false, m3 = false, m5 = false, m7 = false, m11 = false;
        if(n % 2 == 0) m2 = true;
        if(n % 3 == 0) m3 = true;
        if(n % 5 == 0) m5 = true;
        if(n % 7 == 0) m7 = true;
        if(n % 11 == 0) m11 = true;

        if(isPrime(n)) return n - 1;
        for(int i = 2; i < n; i++) {
            if((m2 && i % 2 == 0) || (m3 && i % 3 == 0) || (m5 && i % 5 == 0) || (m7 && i % 7 == 0) || (m11 && i % 11 == 0)) continue;
            if((n % i == 0)) continue;
            if(cmmdc(n, i) == 1)
                nr++;
        }
        return nr;
    }
