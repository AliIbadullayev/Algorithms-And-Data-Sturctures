package max_dist_to_clothest_person;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,0,};
        System.out.println(Solution.maxDistToClosest(arr));
    }

    static class Solution {
        static public int maxDistToClosest(int[] seats) {
            int dist = 0;
            int res = 0;
            boolean left = false;
            for (int i=0; i< seats.length; i++){
                if (seats[i] == 0){
                    dist++;
                }
                else if (seats[i] != 0){
                    if (left){
                        res = getRes(dist, res);
                    }
                    //for first time
                    else {
                        if (res<dist){
                            res = dist;
                        }
                    }
                    dist = 0;
                    left = true;
                }
                if (i == seats.length - 1){
                    if (res<dist){
                        res = dist;
                    }
                }
            }

            return res;
        }

        // method that counts between dist according to value
        private static int getRes(int dist, int res) {
            if (dist % 2 == 0){
                if (res < (dist)/2)
                    res = dist/2;
            } else {
                if (res < (dist+1)/2)
                    res = (dist+1)/2;
            }
            return res;
        }
    }
}
