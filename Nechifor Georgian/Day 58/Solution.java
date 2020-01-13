//https://leetcode.com/problems/single-number/
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length - 1; i+=2) {
            if(nums[i] != nums[i+1]) {
                if(i == 0) return nums[0];
                else if(nums[i-1] == nums[i]) return nums[i+1];
                else return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
