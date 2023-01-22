package some_other_contests;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        in.nextLine();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        int res = 0;

        int realSum = a*x + b*y + c*z;
        for (int i = 0; i <= realSum; i++){
            for (int j = 0; j <= realSum; j++){
                for (int k = 0; k <= realSum; k++){
                    int possibleSum = i*a+j*b+k*c;
                    if (realSum == possibleSum){
                        System.out.println(i+" "+j+" "+k);
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
