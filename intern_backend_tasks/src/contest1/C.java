package contest1;

import java.util.*;

public class C {
    public static void main(String[] args) {
        int times =1000;
        for(int time = 0; time<times; time++ ) {
            int n = (int) (Math.random() *10000);
            int[] array = new int[n];
            boolean flag=false;
            int temp = 2;
            for(int i = 0; i<n; i++){
                int random = (int) (Math.random()*(n-i+1));
                if(random==0) flag =true;
                while((random = random -1) >= 0){
                    array[i] = temp;
                    i++;
                    flag = true;
                }
                temp *=2;
                if (flag){
                    i--;
                    flag = false;
                }

            }
            List<Integer> res1 = fast(n, array);
            List<Integer> res2 = slow(n, array);
            if (res1.equals(res2)) {
                System.out.println(" Array List are equal");
                System.out.println(res1);
                System.out.println(res2);
            }
            else
            {

                break;
            }
        }

    }

    public static List<Integer> fast(int n, int[] array){
        List<Integer> res = new ArrayList<>();
        int temp = 0;
        int r = 0;
        for(int i = 0; i < n; i++ ){
            temp = array[i];
            if (temp != r){
                res.add(temp);
                r = temp;
            }
        }
        return res;
    }

    public static List<Integer> slow(int n, int[] array){
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i++ ){
            set.add(array[i]);
        }
        return new ArrayList<>(set);
    }

//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//    int temp = 0;
//    int res = 0;
//        for(int i = 0; i < n; i++ ){
//        temp = scanner.nextInt();
//        if (temp != res){
//            System.out.println(temp);
//            res = temp;
//        }
//    }

//    Set<Integer> set = new TreeSet<>();
//    Scanner scanner = new Scanner(System.in);
//    int n = scanner.nextInt();
//        for(int i = 0; i < n; i++ ){
//        set.add(scanner.nextInt());
//    }
//
//        for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
//        Integer i = it.next();
//        System.out.println(i);
//    }
}
