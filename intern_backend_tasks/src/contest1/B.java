package contest1;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        int res = 0;
        int temp = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i<n ; i++){
            if (scanner.nextInt() == 1){
                temp += 1;
            }
            else {
                if(res < temp)
                    res = temp;
                temp = 0;
            }
        }
        if(res < temp)
            res = temp;
        temp = 0;
        System.out.println(res);
    }
}
