import java.util.*;

public class SamePrimeFactors {
    private static volatile List<Integer> v = new ArrayList<>();

    private static int palindrome(int n) {
        StringBuilder s = new StringBuilder(Integer.toString(n));
        s = s.reverse();
        return Integer.parseInt(s.toString());
    }

    private static Set<Integer> factors(int n) {
        Set<Integer> t = new HashSet<>();
        int aux = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                t.add(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        if(n > 1) t.add(n);
        //System.out.println(t);
        return t;
    }

    public static int[] sameFactRev(int nMax) {
        int k = 0;
        for (int i = 1080 ; i < nMax; i++) {
            int p = palindrome(i);
            if (i != p) {
                Set<Integer> first = factors(i);
                Set<Integer> second = factors(p);
                if (first.size() > 1 || second.size() > 1) {
                    if (first.equals(second))
                        v.add(i);
                }
            }
        }
        int[] vec = new int[v.size()];
        for (Integer i : v)
            vec[k++] = i;
        v.removeAll(v);
        return vec;
    }

    
}
