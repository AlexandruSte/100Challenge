 //https://leetcode.com/problems/counting-bits/
    public int count(int n) {
        int k = 0;
        while(n != 0) {
            if(n % 2 != 0) k++;
            n /= 2;
        }
        return k;
    }
    public int[] countBits(int num) {
        int[] v = new int[num];
        for(int i = 0; i <= num; i++) {
            v[i] = count(i);
        }

        return  v;
    }
