package hw_1;

import java.util.Scanner;

public class E {

    public static void solution() {
        Scanner scan = new Scanner(System.in);
        int d = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        if (checkTriangle(d, x, y)) {
            System.out.println(0);
        } else {
            double distA = findDist(0, 0, x, y);
            double distB = findDist(d, 0, x, y);
            double distC = findDist(0, d, x, y);
            if (distA <= distB && distA <= distC)
                System.out.println(1);
            else if (distB <= distC && distB <= distA)
                System.out.println(2);
            else
                System.out.println(3);
        }

    }
    private static double findDist(int x0, int y0, int x, int y) {
        return Math.sqrt(Math.pow(x-x0,2)+Math.pow(y-y0,2));
    }

    private static boolean checkTriangle(int d, int x, int y) {
        return x>=0 && y>=0 && y<=-x+d;
    }

}
