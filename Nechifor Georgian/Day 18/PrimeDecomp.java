import java.util.*;
import java.util.stream.Collectors;

public class PrimeDecomp {
   
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n <= 1) return false;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i < n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }

    public static String factors(int n) {
        Map<Integer, Integer> v = new HashMap<>();
        for (int i = 2; i <= n; ) {
            if (n % i != 0) {
                i++;
            } else if (isPrime(i) && n % i == 0) {
                if (v.containsKey(i))
                    v.put(i, v.get(i) + 1);
                else
                    v.put(i, 1);
                n /= i;
            }

        }

        StringBuilder rez = new StringBuilder();
        List<Map.Entry> v2 = new ArrayList<>();
        v2 = v.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());

        for(int i = 0; i < v2.size(); i++) {
            int value = (int) v2.get(i).getValue();
            int key = (int) v2.get(i).getKey();
            if (value == 1)
                rez.append("(").append(key).append(")");
            else
                rez.append("(").append(key).append("**").append(value).append(")");
        }
        return rez.toString();
    }
       
}
