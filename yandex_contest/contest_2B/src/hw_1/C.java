package hw_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        solution(n, arr);
        solution_slow(n, arr);

    }

    public static void solution(int n, int[] arr) {
        System.out.println(arr[n/2]);
    }
    public static void solution_slow(int n, int[] arr){
        long res = 0;

        HashMap<Integer, Long> map = new HashMap<>();

        for (int i = arr[0]; i< arr[arr.length-1];i++){
            for (int j = 0; j<n; j++){
                res += Math.abs(arr[j] - i);
            }

            map.put(i, res);
            res = 0;
        }
        Optional<Map.Entry<Integer, Long>> min = map.entrySet().stream().min((a, b)->a.getValue().compareTo(b.getValue()));
        System.out.println(min.get().getKey());

    }
}
