public class SumString {
    private String strsum(String a, String b) {
        StringBuilder bBuilder = new StringBuilder(b);
        StringBuilder aBuilder = new StringBuilder(a);
        int c = a.length() - b.length();
        if(c > 0) {
            while(c-- != 0) bBuilder.insert(0, '0');
            b = bBuilder.toString();
        } else {
            while(c++ != 0) aBuilder.insert(0, '0');
            a = aBuilder.toString();
        }
        int len = a.length(), temp = 0;
        char[] cRez = new char[len], cA = a.toCharArray(), cB = b.toCharArray();
        for(int i = 0; i < len; i++) {
            int aux = (cA[i] - '0') + (cB[i] - '0') + temp;
            if(aux > 9) {
                cRez[i] = (char) (aux % 10);
            } else {
                cRez[i] = (char)(aux + '0');
            }
            temp = aux / 10;
        }
        return String.valueOf(cRez);
    }
}
