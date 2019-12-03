import java.util.Arrays;

class GapInPrimes {
    
   private static boolean isPrime(long n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(long i = 5; i * i <= n; i++) {
            if(n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    private static long nextPrime(long n) {
        boolean found = false;
        long prime = n;
        while(!found) {
            prime++;
            if(isPrime(prime))
                found = true;
        }
        return prime;
    }

    public static long[] gap(int g, long m, long n) {
        // your code
        for(long i = m; i <= n; i++) {
            if(isPrime(i)) {
                long aux = nextPrime(i);
                if(aux - i == g) {
                    return new long[] {i, aux};
                }
            }
        }
        return null;
    }
}
