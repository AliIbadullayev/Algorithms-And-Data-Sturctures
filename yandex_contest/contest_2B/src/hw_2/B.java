package hw_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void solution() {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] left = new int[10];
        int res = 0;
        int market_pos = -20;

        for (int i = 0; i < 10; i++){
            arr[i] = scan.nextInt();
        }
        for (int i = 0; i < 10; i++){
            if (arr[i] == 2)
                market_pos = i;
            if (arr[i] == 1)
                left[i] = (i - market_pos);
        }
        market_pos = 30;
        for (int i = 9; i >=0 ; i--){
            if (arr[i] == 2)
                market_pos = i;
            if (arr[i] == 1){
                res = Integer.max(Integer.min(left[i],market_pos - i),res);
            }
        }
        System.out.println(res);
    }
    public static void solution_slow(){
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> markets = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            arr[i] = scan.nextInt();
            if (arr[i] == 2) {
                markets.add(i);
            } else if (arr[i] == 1)
                map.put(i, 100);
        }

        for (Integer m: markets){
            for(Integer h: map.keySet()){
                if (map.get(h) > Math.abs(m - h)){
                    map.replace(h, Math.abs(m - h));
                }
            }
        }

        System.out.println(map.values().stream().sorted().toArray()[map.size()-1]);
    }
}
