package some_other_contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = Integer.MIN_VALUE;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int some = in.nextInt();
            in.nextLine();
            arr.add(some);
            if (arr.size()>1){
                res = Integer.MIN_VALUE;
                for (int j=0; j < arr.size(); j++){
                    for(int k = j+1; k< arr.size(); k++){
                        res = Math.max(res, arr.get(j) ^ arr.get(k));
                    }
                }
                System.out.println(res);
            }

        }

    }
}
