import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int sum = l1 + l2;

        if (l1 == 0){
            return l2 % 2 == 0 ? (double) (nums2[l2/2-1] + nums2[l2/2])/2 : nums2[l2/2];
        }
        if (l2 == 0){
            return l1 % 2 == 0 ? (double) (nums1[l1/2-1] + nums1[l1/2])/2 : nums1[l1/2];
        }
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (l1 + l2 != list.size()){
            if (j == l2 || (i < l1  && nums1[i] < nums2[j] )){
                list.add(nums1[i++]);
            }
            else {
                list.add(nums2[j++]);
            }
            if (sum % 2 == 0){
                if (i + j == sum / 2 + 1){
                    return (double) (list.get(i+j-1) + list.get(i+j-2))/2;
                }
            } else {
                if (i + j == sum / 2 + 1){
                    return list.get(i+j-1);
                }
            }
        }
        return 0;
    }


}
