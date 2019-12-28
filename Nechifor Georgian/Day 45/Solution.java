//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
      public int search(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        if (l <= r) {
            if (nums[mid] == target)
                return mid;

            if(nums[mid] < target) {
                if(nums[mid] > nums[r] || target <= nums[r]) {
                    return search(nums, target, mid + 1, r);
                }
                return search(nums, target, l, mid - 1);
            }
            else if(nums[mid] > target) {
                if(nums[mid] < nums[r] || nums[l] <= target) {
                    return search(nums, target, l, mid - 1);
                }
                return search(nums, target, mid + 1, r);
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
}
