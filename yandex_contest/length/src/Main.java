import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = in.nextInt();
        }
        dist(arr, n , k);

    }

    public static void dist(int[] arr, int n, int k){
        HashMap<Integer, Integer> res = new LinkedHashMap<>();
        List<Integer> sorted_arr = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        int s = sorted_arr.stream().skip(1).limit(k).mapToInt(Integer::intValue).sum() - k* sorted_arr.get(0);
        res.put(sorted_arr.get(0), s);
        int nums_at_left = 0;
        int nums_at_right = k;

        for (int i = 1; i<n; i++){
            nums_at_left++;
            nums_at_right--;
            int dif = sorted_arr.get(i) - sorted_arr.get(i-1);
            s = s - dif*nums_at_right + dif*(nums_at_left-1);
            while (nums_at_right + i + 1 < n ){
                int l = sorted_arr.get(i) - sorted_arr.get(i-nums_at_left);
                int r = sorted_arr.get(nums_at_right + i + 1) - sorted_arr.get(i);
                if (l > r ){
                    nums_at_right++;
                    nums_at_left--;
                    s -= l-r;
                } else
                    break;
            }
            res.put(sorted_arr.get(i), s);
        }
        for (int i = 0; i < n; i++){
            System.out.print(res.get(arr[i]) +" ");
        }
    }
}
