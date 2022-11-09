package max_consecutive_ones;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(Solution.longestOnes(nums, k));
    }

    static class Solution {
        static public int longestOnes(int[] nums, int k) {


            int res = 0;
            List<Integer> nulls = new ArrayList<>();
            for (int i=0; i<nums.length; i++){
                if (nums[i] == 0 ){
                    nulls.add(i);
                }
            }

            if (nulls.size() <= k ){
                return nums.length;
            }

            for (int i=0; i<=nulls.size()-k; i++){
                if (i == 0 || i == nulls.size() - k){
                    if (i == 0){
                        res = Math.max(res, nulls.get(i + k));
                    }
                    else {
                        res = Math.max(res, nums.length - nulls.get(i - 1) - 1);
                    }
                }
                else {
                    res = Math.max(res, nulls.get(i + k) - nulls.get(i - 1) - 1 );
                }
            }
            return res;
        }
    }
}
