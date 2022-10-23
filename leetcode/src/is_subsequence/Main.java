package is_subsequence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        System.out.println(Solution.isSubsequence(s,t));
    }

    static class Solution {
        static public boolean isSubsequence(String s, String t) {
            List<Character> chars = new ArrayList<>();
            for (char c: s.toCharArray()){
                chars.add(c);
            }
            if (s.equals(""))
                return true;

            for (int i = 0; i < t.length(); i++){
                if (t.charAt(i) == chars.get(0)){
                    chars.remove(0);
                    if (chars.isEmpty())
                        break;
                }
            }
            return chars.isEmpty();
        }
    }
}
