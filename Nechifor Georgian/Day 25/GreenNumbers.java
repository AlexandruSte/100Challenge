import java.math.BigDecimal;
import java.math.BigInteger;

public class GreenNumbers {

    private static int noOfDigits(BigInteger n) {
        return n.toString().length();
    }

    private static BigInteger lastDigits(BigInteger n, int x) {
        int aux = BigDecimal.TEN.pow(x).intValue();
        return n.mod(BigInteger.valueOf(aux));
    }

    private static boolean isGreen(BigInteger n) {
        int aux = n.mod(BigInteger.TEN).intValue();
        if (!(aux == 1 || aux == 5 || aux == 6)) {
            return false;
        }
        aux = n.mod(BigInteger.valueOf(100)).intValue();
        if(n.compareTo(BigInteger.TEN) > 0) {
            if(! (aux == 25 || aux == 76)) {
                return false;
            }
        }
        if(n.mod(BigInteger.valueOf(5)).compareTo(BigInteger.ZERO) < 0) return false;
        if(n.mod(BigInteger.valueOf(6)).compareTo(BigInteger.ZERO) < 0) return false;
        BigInteger nS = n.multiply(n);
        BigInteger lastDigits = lastDigits(nS, noOfDigits(n));
        return lastDigits.compareTo(n) == 0;

    }

    public static BigInteger get(int n) {
        BigInteger nr = BigInteger.ZERO;
        BigInteger i = BigInteger.ZERO;
        while (nr.intValue() - n < 0) {
            i = i.add(BigInteger.ONE);
            if (isGreen(i)) {
                nr = nr.add(BigInteger.ONE);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(get(30));
    }
}
