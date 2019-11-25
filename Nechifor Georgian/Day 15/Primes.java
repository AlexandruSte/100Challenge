import java.util.stream.IntStream;

public class Primes {
   private static boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i = 5; i*i <= n; i+= 6) {
            if(n%i==0 || n%(i+2)==0)
                return false;
        }
        return true;
    }

    private static int nextPrime(int n) {
        if(n <= 1) return 2;
        boolean found = false;
        int prime = n;
        while(!found) {
            prime++;

            if(isPrime(prime))
                found = true;
        }
        return prime;
    }
    public static IntStream stream() {
        return IntStream.iterate(2, Primes::nextPrime);
    }
}
