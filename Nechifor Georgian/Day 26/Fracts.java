public class Fracts {

    private static long divisor(long a, long b) {
        if(a == 0) return b;
        return divisor(b % a, a);
    }

    private static long finder(long[] lst) {
        long result = lst[0];
        for(int i = 1; i < lst.length; i++) {
            result = (lst[i] * result) / divisor(result, lst[i]);
            if (result == 1)
                return 1;
        }
        return result;
    }

    public static String convertFrac(long[][] lst) {
        if(lst.length == 0) return "";
        long[] dominators = new long[lst.length];

        for(int i = 0; i < lst.length; i++) {
            long aux = divisor(lst[i][0], lst[i][1]);
            lst[i][0] /= aux;
            lst[i][1] /= aux;
        }

        for(int i = 0; i < lst.length; i++)
            dominators[i] = lst[i][1];
        long cmd = finder(dominators);

        //System.out.println(cmd);
        for(int i = 0; i < lst.length; i++) {
            long aux = lst[i][1];
            //System.out.println(aux);
            lst[i][0] *= cmd;
            lst[i][1] *= cmd;

            lst[i][0] /= aux;
            lst[i][1] /= aux;

        }

        String rez = "";
        for(int i = 0; i < lst.length; i++) {
            rez += "(" + lst[i][0] + "," + lst[i][1] + ")";
        }

        return rez;
    }

    public static void main(String[] args) {
        System.out.println(convertFrac(new long[][]{{1, 2}, {1, 3}, {10, 40}}));
    }
}
