import java.util.Scanner;

public class B {
    public static void solution(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int begin = scan.nextInt();
        int end = scan.nextInt();
        if (end > begin){
            if (end - begin > n/2) System.out.println( n-end + begin - 1);
            else System.out.println(end - begin - 1 );
        } else {
            if (begin - end > n/2) System.out.println(n-begin + end - 1);
            else System.out.println(begin - end -1) ;
        }
    }
}
