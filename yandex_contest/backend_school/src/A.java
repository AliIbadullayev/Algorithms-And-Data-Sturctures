import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class A {
    public static void solution() {
        Scanner scan = new Scanner(System.in);
        char[] a = scan.next().toCharArray();
        char[] b = scan.next().toCharArray();
        char[] res = new char[a.length];

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : a) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.replace(c, map.get(c) + 1);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {

                res[i] = 'P';
                map.replace(b[i], map.get(b[i]) - 1);
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (res[i] != 0) continue;
            if (map.containsKey(b[i]) && map.get(b[i]) != 0) {
                res[i] = 'S';
                map.replace(b[i], map.get(b[i]) - 1);
            } else res[i] = 'I';
        }

        for (char r : res) {
            System.out.print(r);
        }
    }
}
