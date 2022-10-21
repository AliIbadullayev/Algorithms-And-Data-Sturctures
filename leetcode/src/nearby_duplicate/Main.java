package nearby_duplicate;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,9};
        int k = 3;

        System.out.println(Solution.containsNearbyDuplicate(nums, k));
}

    static class Solution {
        static public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k >= nums.length){
                k = nums.length - 1;
            }

            for (int i=0; i<nums.length; i++){
                if (i+k > nums.length-1){
                    k--;
                }
                for (int j=1; j<=k; j++){
                    if (nums[i] == nums[i+j]){

                        return true;
                    }
                }
            }



            return false;
        }
    }
}
