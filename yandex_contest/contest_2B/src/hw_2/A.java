package hw_2;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class A {
    public static void solution() {
        Scanner scan = new Scanner(System.in);
        SortedMap<Integer, Integer> map = new TreeMap<>();
//        List<Integer> list = new ArrayList<>();
        int num;
        while ((num = scan.nextInt()) != 0){
//            list.add(num);
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.replace(num, map.get(num)+1);


        }
        System.out.println(map.get(map.lastKey()));
//        list = list.stream().sorted().collect(Collectors.toList());
//        int max = list.get(list.size()-1);
//        System.out.println(list.stream().filter((a)->a==max).count());
//        int max = list.get(0);
//        for (int i = 1; i < list.size(); i++){
//            max = Integer.max(max, list.get(i));
//        }
//        int res = 0;
//        for (int i = 0; i < list.size(); i++){
//            if (list.get(i) == max)
//                res++;
//        }
//        System.out.println(res);
    }
}
