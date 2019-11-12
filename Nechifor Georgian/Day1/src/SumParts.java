import java.util.Arrays;

public class SumParts {

    private int[] sums(int[] ls) {
        int[] sume = new int[ls.length + 1];
        int sum = Arrays.stream(ls).sum();
        int aux = 0;
        for(int i = 0; i < ls.length; i++) {
            sume[i] = sum - aux;
            aux += ls[i];
        }
        return sume;
    }
    public static void main(String[] args) {
        SumParts sp = new SumParts();
        int[] s = new int[] {0, 1, 3, 6, 10};
        int[] rez = sp.sums(s);
        for(int value : rez)
            System.out.print(value + " ");
    }
}
