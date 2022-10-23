package isomorphic_strings;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s = "abc";
        String t = "cdd";
        System.out.println(Solution.isIsomorphic(s,t));
    }

    static class Solution {
        static public boolean isIsomorphic(String s, String t) {
            int temp = 0;
            HashMap<Character, Integer> dict1 = new HashMap<>();
            HashMap<Character, Integer> dict2 = new HashMap<>();
            char[] s_chars = s.toCharArray();
            char[] t_chars = t.toCharArray();
            for (char c: s_chars){
                if (!dict1.containsKey(c)){
                    dict1.put(c,temp++);
                }
            }
            temp =0;
            for (char c: t_chars){
                if (!dict2.containsKey(c)){
                    dict2.put(c,temp++);
                }
            }
            for (int i = 0; i<s.length(); i++){
                if (!dict1.get(s_chars[i]).equals(dict2.get(t_chars[i]))){
                    return false;
                }
            }
            return true;
        }
    }
}
