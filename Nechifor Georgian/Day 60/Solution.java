https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] aux = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    aux[0] = i+1;
                    aux[1] = j+1;
                    return aux;
                }
            }
        }
        return aux;
    }
}
