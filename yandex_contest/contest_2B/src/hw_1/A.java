package hw_1;

import java.util.Scanner;

public class A {
    public static void solution(){
        Scanner scan = new Scanner(System.in);
        int exit_code = scan.nextByte();
        int interact = scan.nextInt();
        int checker = scan.nextInt();

        if (interact == 0 ){
            if(exit_code != 0) System.out.println(3);
            else System.out.println(checker);
        }
        else if (interact == 4){
            if(exit_code != 0) System.out.println(3);
            else System.out.println(4);
        }
        else if (interact == 1) System.out.println(checker);
        else if (interact == 6) System.out.println(0);
        else if (interact == 7) System.out.println(1);
        else System.out.println(interact);
    }
}
