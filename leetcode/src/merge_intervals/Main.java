package merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,4},{4,5}};
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(Solution.merge(arr)));
    }

    static class Solution {
        static public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            System.out.println(Arrays.deepToString(intervals));
            int n = intervals.length;
            int count = 0;
            int end = 0;
            int begin = 0;
            int pos = 0;
            while (count != n){
                try {
                    begin = intervals[count][0];
                    end = intervals[count][1];
                    count++;
                    int next = intervals[count][0];
                    while (end >= next) {
                        if (end <= intervals[count][1])
                            end = intervals[count][1];
                        count++;
                        next = intervals[count][0];

                    }
                    System.out.println(begin +" "+ end);
                    intervals[pos] = new int[]{begin, end};
                    pos++;
                }catch (IndexOutOfBoundsException e){
                    System.out.println(begin +" "+ end);
                    intervals[pos] = new int[]{begin, end};
                }
            }
            return Arrays.copyOfRange(intervals, 0, pos+1);
        }
    }
}
