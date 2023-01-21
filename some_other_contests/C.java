package some_other_contests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = Integer.MAX_VALUE;
        int a =0 , b = 0;
        for (int i = 1; i <= n/2; i++){
            int currLCM = findLCM(i, n-i);
            if (res > currLCM){
                a = i;
                b = n-i;
                res = currLCM;
            }
        }
        System.out.println(a + " " + b);
//        System.out.println(findLCM(4, 5));
    }
    public static int findLCM(int a, int b){
        HashMap<Integer, Integer> derives1 = new HashMap<>();
        HashMap<Integer, Integer> derives2 = new HashMap<>();
        int res = 1;
        if (a == 0||b == 0)
            return 0;

        if (a<b){
            int c = a;
            a = b;
            b = c;
        }

        while(a != 1){
            int count = 2;
            while (a % count != 0)
                count++;
            derives1.put(count, derives1.getOrDefault(count, 0) + 1);
            a = a/count;
        }
        while(b != 1){
            int count = 2;
            while (b % count != 0)
                count++;
            derives2.put(count, derives2.getOrDefault(count, 0) + 1);
            b = b/count;
        }

        for(Map.Entry<Integer, Integer> entry: derives2.entrySet()){
//            if (derives1.containsKey(entry.getKey())){
                int count =  entry.getValue() - derives1.getOrDefault(entry.getKey(),0);
                if (count > 0 ) {
                    derives1.put(entry.getKey(), derives1.getOrDefault(entry.getKey(), 0) + count);
                }
//            }
        }

        for(Map.Entry<Integer, Integer> entry: derives1.entrySet()) {
            res *= Math.pow(entry.getKey(),entry.getValue());
        }
        return res;
    }
}
