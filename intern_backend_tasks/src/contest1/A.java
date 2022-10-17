package contest1;

import java.util.HashMap;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        char[] read;
        read = scanner.nextLine().toCharArray();
        for(char letter: read){
            map.put(letter, 0);
        }
        read = scanner.nextLine().toCharArray();
        for(char letter: read){
            if (map.containsKey(letter))
            map.replace(letter, map.get(letter)+1);
        }
        int res = 0;
        for(int i : map.values()){
            res+=i;
        }
        System.out.println(res);
    }
}
