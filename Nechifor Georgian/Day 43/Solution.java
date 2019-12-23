//https://leetcode.com/problems/permutations/

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    private void permuteHelper(int[] nums, int l, int r) {
        if(l == r) {
            List<Integer> aux = new ArrayList<>();
            IntStream.of(nums).forEach(aux::add);
            list.add(aux);
        } else {
            for(int i = l; i <= r; i++) {
                int aux = nums[i];
                nums[i] = nums[l];
                nums[l] = aux;
                permuteHelper(nums, l+1, r);

                aux = nums[i];
                nums[i] = nums[l];
                nums[l] = aux;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums, 0, nums.length - 1);
        return list;
    }
}
