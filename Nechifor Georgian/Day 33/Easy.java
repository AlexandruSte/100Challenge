public class Easy {

//https://leetcode.com/problems/happy-number/submissions/
    public boolean isHappy(int n) {
        int result = 0;
        int iteration = 0;
        while (result != 1 && iteration <= 100) {
            result = 0;
            while (n != 0) {
                result += (n % 10) * (n % 10);
                n /= 10;
            }
//            System.out.println(result);
            n = result;
            iteration++;
        }
        if (result != 1)
            return false;
        return true;
    }

    //https://leetcode.com/problems/count-primes/
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
    private static int nextPrime(int n) {
        if (n <= 1) return 2;
        boolean found = false;
        int prime = n;
        while (!found) {
            prime++;

            if (isPrime(prime))
                found = true;
        }
        return prime;
    }
    public int countPrimes(int n) {
        int count = (int) IntStream.iterate(2, Easy::nextPrime).limit(n).filter(i -> i < n).count();
        return count;
    }

    //https://leetcode.com/problems/valid-anagram/submissions/
    public boolean isAnagram(String s, String t) {
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        for (int i = 0; i < s.length(); i++) {
            freq1[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++)
            freq2[t.charAt(i)]++;

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}
