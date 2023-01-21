package max_average_pass_ratio;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<int[]> list;
        int [][] l = new int[100][2];
        for (int i = 0; i < l.length; i++){
            l[i][0] = (int) (Math.random() * 10);
            l[i][1] = l[i][0] + (int) (Math.random() * 10);
        }
        list = new ArrayList<>(Arrays.stream(l).toList());
//        System.out.println(Arrays.deepToString(list.toArray()));
        for (int i = 0; i<10 ; i++ ) {
            long start = System.nanoTime();
            list.sort(Comparator.comparingDouble(a -> -(((double) a[0] + 1) / ((double) a[1] + 1) - ((double) a[0] / (double) a[1]))));
//            Collections.reverse(list);
//            long end = System.nanoTime();
//            System.out.println(end - start);
            int[] arr = list.get(i);
            arr[0] = arr[0]+1;
            arr[1] = arr[1]+1;

            ListIterator<int[]> listIterator = list.listIterator();
            listIterator.next();
            listIterator.remove();
            listIterator.add(arr);

            list.remove(0);
            list.add(0, arr);

            long end = System.nanoTime();
            System.out.println(end - start);
        }
//        double res = 0d;
//        list.forEach((a)->{
//
//        });
//        System.out.println(Arrays.deepToString(list.toArray()));

    }
}
