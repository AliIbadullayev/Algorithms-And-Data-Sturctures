package set_mismatch;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(Solution.findErrorNums(nums)));

    }
    static public class Solution {
        static public int[] findErrorNums(int[] nums) {
            Map < Integer, Integer > map = new HashMap();
            int dup = -1, missing = 1;
            for (int n: nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            for (int i = 1; i <= nums.length; i++) {
                if (map.containsKey(i)) {
                    if (map.get(i) == 2)
                        dup = i;
                } else
                    missing = i;
            }
            return new int[]{dup, missing};
        }
    }
}
