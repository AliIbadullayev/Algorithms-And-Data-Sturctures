package deleting_element_in_subarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1};
        HashMap<Integer, Integer> dict = new HashMap<>();
        int ones = 0;
        int previous = 0;
        int previous_zero = 0;
        boolean right_flag = false;
        for (int i = 0; i<nums.length; i++){

            if (nums[i]==1){
                ones++;
                if(i == nums.length - 1) {
                        dict.put(previous_zero, dict.getOrDefault(previous_zero, 0) + ones);

                }
            }
            if(nums[i] == 0 ){
                if (previous == 0 ){
                    right_flag = false;
                }
                else {
                    if (right_flag) {
                        dict.put(previous_zero, dict.getOrDefault(previous_zero, 0) + ones);
                    }
                    dict.put(i, dict.getOrDefault(i, 0) + ones);
                    right_flag = true;
                }
                ones = 0;
                previous_zero = i;
            }
            previous = nums[i];

        }
        if (dict.isEmpty())
            if (Arrays.stream(nums).allMatch((a)-> a==0)){
                System.out.println( 0);
            }
            else if (Arrays.stream(nums).allMatch((a)-> a==1)){
                System.out.println(nums.length-1);
            }
            else {
                System.out.println(nums.length-1);
            }
        else{
            System.out.println(Collections.max(dict.values()));
        }
    }
}
