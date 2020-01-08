//https://leetcode.com/problems/reverse-integer/
class Solution {
    public int reverse(int x) {
        int neg = 0;
        if(x < 0) neg = 1;
        x = Math.abs(x);
        long xAux = 0;
        while(x != 0) {
            xAux = xAux * 10 + x % 10;
            x /= 10;
        }
        
        if(neg == 1)
            xAux = -xAux;
        if(xAux > Integer.MAX_VALUE)
            return 0;
        if(xAux < Integer.MIN_VALUE)
            return 0;
        return (int)xAux;
    }
}
