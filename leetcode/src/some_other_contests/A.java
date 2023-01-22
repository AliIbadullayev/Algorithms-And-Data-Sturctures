package some_other_contests;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String word = in.nextLine();
        String colors = in.nextLine();
        int res = 0;

        String[] words = word.split(" ");
        for (String w: words){
            boolean flagNotBeautiful = false;
            char[] colorChars = colors.substring(0, w.length()).toCharArray();
            colors = colors.substring(w.length());
            char lastColor = '0';
            for (char c: colorChars){
                if (lastColor == '0') {
                    lastColor = c;
                    continue;
                }
                if (c == lastColor) {
                    flagNotBeautiful = true;
                    break;
                }
                lastColor = c;
            }
            if (flagNotBeautiful)
                res++;
        }
        System.out.println(res);
    }
}
