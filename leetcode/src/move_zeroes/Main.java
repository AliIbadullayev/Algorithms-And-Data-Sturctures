package move_zeroes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0};
        Solution.moveZeroes(nums);
    }

    static class Solution {
        static public void moveZeroes(int[] nums) {
            int curr_zero;
            for (int i = nums.length-1; i>=0; i--){
                if (nums[i] == 0){
                    curr_zero = i;
                    while (curr_zero!= nums.length-1 && nums[curr_zero+1] != 0){
                        int temp = nums[curr_zero];
                        nums[curr_zero] = nums[curr_zero+1];
                        nums[curr_zero+1] = temp;
                        curr_zero++;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
