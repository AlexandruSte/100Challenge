import java.sql.Time;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SamePrimeFactors {
    private static volatile List<Integer> v = new ArrayList<>();

    private static int palindrome(int n) {
        StringBuilder s = new StringBuilder(Integer.toString(n));
        s = s.reverse();
        return Integer.parseInt(s.toString());
    }

    private static Set<Integer> factors(int n) {
        Set<Integer> t = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                t.add(i);
                while (n % i == 0)
                    n /= i;
            }
        }
        return t;
    }

    private static synchronized void sameFactRevHelper(int m, int n) {
        int k = 0;
        for (int i = m; i <= n; i++) {
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
    }

    public static int[] sameFactRev(int nMax) {
        Thread[] t = new Thread[5];
        t[0] = new Thread(() -> sameFactRevHelper(1080, nMax / 9));
        t[1] = new Thread(() -> sameFactRevHelper(nMax / 9 + 1, nMax / 6));
        t[2] = new Thread(() -> sameFactRevHelper(nMax / 6 + 1, nMax / 3));
        t[3] = new Thread(() -> sameFactRevHelper(nMax / 3 + 1, nMax));

        ExecutorService poll = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 4; i++)
            poll.execute(t[i]);
        poll.shutdown();
        try {
            poll.awaitTermination(16, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int k = 0;
        Collections.sort(v);
        int[] vec = new int[v.size()];
        for (Integer i : v)
            vec[k++] = i;
        v.removeAll(v);
        return vec;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println(Arrays.toString(sameFactRev(2104312431)));

        long end = System.currentTimeMillis();

        System.out.println((end - start) / 1000);
    }
}
