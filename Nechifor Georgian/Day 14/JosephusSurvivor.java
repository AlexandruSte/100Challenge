import java.util.LinkedList;

public class JosephusSurvivor {
    private static int calculate(final int n, final int k, int temp) {
        int aux = temp;
        for(int i = 0; i < k; i++) {
            if(aux > n - 1) {
                aux = 0;
            }
            aux++;
        }
        return aux;
    }
    public static int josephusSurvivor(final int n, final int k) {
        LinkedList<Integer> v = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            v.add(i);
        }
        int nr = n;
        int index = 0;
        while(nr != 1) {
            index = calculate(nr, k, index) - 1;
            v.remove(index);
            nr--;
        }
        return v.get(0);
    }
}