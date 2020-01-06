class Solution {
    //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                if(xor > max) {
                    max = xor;
                }
            }
        }
        return max;
    }
}
