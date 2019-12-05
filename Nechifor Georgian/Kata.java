public class Kata {

  public static long divisibleCount(long x, long y, long k) {
        if (x % k == 0)
            return (y / k) - (x / k) + 1;
        return (y / k) - (x / k);
    }
  
}
