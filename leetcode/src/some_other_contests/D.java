package some_other_contests;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double radians = Math.toRadians((float)(180 / n));
        double s = n / (4 * Math.tan(radians));
        if (n % 2 != 0)
            System.out.println(s);
        else
            System.out.println((0.46180342 * s));
    }
}
