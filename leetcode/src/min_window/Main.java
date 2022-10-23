package min_window;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "dacba";
        String t = "ab";
        System.out.println(Solution.minWindow(s,t));
    }

    static class Solution {
        static public String minWindow(String s, String t) {
            int pointer1 = 0;
            int pointer2 = 0;
            int min_left = 0;
            int min_right = Integer.MAX_VALUE;

            char[] s_char = s.toCharArray();
            char[] t_char = t.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> map_copy = formMap(t_char);

            while (pointer1 != s_char.length){
                char curr = s_char[pointer1];
                if (map_copy.containsKey(curr)){
                    map.put(curr, map.getOrDefault(curr, 0)+1);
                }
                if (checkMap(map, map_copy)){
                    while (checkMap(map, map_copy)){
                        char minimize = s_char[pointer2];
                        if (map_copy.containsKey(minimize)){
                            map.put(minimize, map.getOrDefault(minimize, 0)-1);
                        }
                        pointer2++;
                    }

                    if (pointer1 - pointer2+1 < min_right - min_left){
                        min_left = pointer2-1;
                        min_right = pointer1;
                    }
                }

                pointer1++;
            }
            if (min_right == Integer.MAX_VALUE) return "";
            return s.substring(min_left, min_right+1);
        }

        static private HashMap<Character, Integer> formMap(char[] t){
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c: t){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            return map;
        }

        static private boolean checkMap(HashMap<Character, Integer> map, HashMap<Character, Integer> map_copy){
            try {
                for (Map.Entry<Character, Integer> e : map_copy.entrySet()) {
                    if (map_copy.get(e.getKey()) > map.get(e.getKey())) {
                        return false;
                    }
                }
                return true;
            }catch (NullPointerException e){
                return false;
            }
        }
    }
}
