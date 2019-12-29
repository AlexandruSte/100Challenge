public class Medium {

    //https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] v) {
        int rez = 0;
        int index = v.length - 1;
        int max = 0;
        for (int i = 0; i < index; ) {
            int aux = Integer.min(v[i], v[index]) * (index - i);
            rez = Integer.max(rez, aux);

            if(v[index] > v[i])
                i++;
            else
                index--;
        }
        return rez;
    }
    
    public int maxArea0(int[] v) {
        int rez = 0;
        int index = 0;
        int max = 0;
        for(int i = 0; i < v.length; i++) {
            for(int j = i; j < v.length; j++) {
                int area = (j - i) * Integer.min(v[i], v[j]);
                if(area > rez) {
                    rez = area;
                }
            }
        }
        return rez;
    }
}
