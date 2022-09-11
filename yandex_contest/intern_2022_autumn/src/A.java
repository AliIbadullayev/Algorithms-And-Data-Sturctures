import java.util.HashSet;
import java.util.Scanner;

public class A {
    public static void A(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] input = new String[n];
        HashSet<Character> set = new HashSet();
        int first_letter = 0;
        int sum_of_date = 0;
        for(int i = 0; i<n; i++){
            input[i] = scan.next();
        }
        for(int i = 0; i<n; i++){
            String[] row = input[i].split(",");

            for (int j = 0; j<3; j++){
                for(char letter: row[j].toCharArray()){
                    set.add(letter);
                }
            }
            for (int j=3; j<5; j++){

                for (char d: row[j].toCharArray())
                    sum_of_date+=Integer.parseInt(String.valueOf(d));
            }
            first_letter = row[0].charAt(0);
            String res = Integer.toHexString(set.size()+sum_of_date*64+(first_letter-64)*256);
            if (res.toCharArray().length >3)res = res.substring(res.length()-3);
            else {
                while (res.length()!=3){
                    res = 0+res;
                }
            }
            System.out.print(res.toUpperCase()+" ");
            set.clear();
            sum_of_date = 0;
            first_letter = 0;
        }
    }
}
