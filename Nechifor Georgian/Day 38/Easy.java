public class Easy {
    
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> aux = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                aux.add(i + 1);
        }
        return aux;
    }

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public int peakIndexInMountainArray(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[i + 1])
                return i;
        }
        return -1;

    }

    //https://leetcode.com/problems/non-decreasing-array
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int k = 0;
        for(int i = 0; i < nums.length - 2 && k <= 1; i++) {
            if(nums[i] > nums[i+1]) {
                if(Math.abs(nums[i-1] - nums[i+1]) == 1 || Math.abs(nums[i] - nums[i+2]) == 1)
                    return false;
                k++;
            }
        }
        return k <= 1;
    }

    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int max = 0;
        int aux = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1])
                max++;
            else
                max = 0;
            aux = Math.max(aux, max);
        }
        if(aux == 0)
            return 1;
        return aux+1;
    }
}
