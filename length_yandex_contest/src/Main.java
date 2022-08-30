import java.util.*;


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] idx = new int[n];
        int[] res = new int[n];
        int[] arr = new int[n];
        int temp = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = in.nextInt();
            idx[i] = i;
        }

        for (int i = 0; i<n; i++){
            for (int j = 1; j < n - i ; j++){
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    temp = idx[j-1];
                    idx[j-1] = idx[j];
                    idx[j] = temp;
                }
            }
        }

        for (int i = 0; i<n; i++){
            int minSum = 0;

            int l = i - 1;
            int r = i + 1;
            for (int t = 0; t < k; t++){
                if (l<0){
                    l = r + 1;
                    if (r>n-1 || l>n-1 || r == 0){
                        l = r;
                    }
                }
                else if (l > n-1){
                    l = r ;
                }
                else if (r<0){
                    r = l;
                }
                else if (r>n-1){
                    r = l - 1;
                    if (l<0 || r<0 || l == n-1){
                        r = l;
                    }
                }
                int tmpL = Math.abs(arr[i] - arr[l]);
                int tmpR = Math.abs(arr[i] - arr[r]);
                if (tmpL < tmpR){
                    minSum += tmpL;
                    if (l>i)
                        if (l>r)
                            l++;
                        else
                            l = r+1;
                    else
                        if (l<r)
                            l--;
                        else
                            l = r-1;
                }
                else {
                    minSum += tmpR;
                    if (r<i)
                        if (r<l)
                            r--;
                        else
                            r = l-1;
                    else
                        if (r < l)
                            r = l+1;
                        else
                            r++;
                }
            }
            res[idx[i]] = minSum;
        }

        for (int i = 0 ; i < n; i++){
            System.out.print(res[i]);
            if (i != n-1){
                System.out.print(" ");
            }
        }
    }
}
