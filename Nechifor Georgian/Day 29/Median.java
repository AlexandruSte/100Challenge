import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Median {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0f;
        List<Integer> nums = new ArrayList<>();
        IntStream.of(nums1).forEach(nums::add);
        IntStream.of(nums2).forEach(nums::add);
        Collections.sort(nums);

        System.out.println(nums);
        int size = nums.size();
        median = (double)(nums.get((size - 1) / 2 ) + nums.get(size / 2)) / 2.0f;
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        Median m = new Median();
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
