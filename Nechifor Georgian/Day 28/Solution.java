public class Solution {
    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        char[] chrs = str.toCharArray();
        
        for(int i = 0; i < chrs.length; i++) //delete first white spaces
            if(chrs[i] != ' ') {
                str = str.substring(i, chrs.length);
                break;
            }
        chrs = str.toCharArray();
        int sign = -1; // positive
        int res = 0;
        int i = 0;
        if(chrs[0] == '-') { //check if negative number
            sign = 0;
            i = 1;
        }
        else if(chrs[0] == '+') { //check again if positive
            sign = 1;
            i = 1;
        }
        else if(!isNumber(chrs[0]))
            return 0;

        if(chrs.length == 1 && (sign != -1)) //check if string contains just the sign
            return 0;
        if(chrs[0] == '-' && chrs[1] == '+' || (chrs[0] == '+' && chrs[1] == '-')) //check for error
            return 0;
        for(; i < chrs.length; i++) {
            if(isNumber(chrs[i])) {
                long test = (long)res * 10 + (chrs[i] - '0'); //check if res overflows int range
                if(test > Integer.MAX_VALUE) {
                    if(sign == 0) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                res = res * 10 + (chrs[i] - '0');
            }
            else
                 break;
        }
        if (sign == 0) //check the sign
            res = -res;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("+"));
    }
}
