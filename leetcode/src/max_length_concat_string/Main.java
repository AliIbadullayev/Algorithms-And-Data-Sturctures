package max_length_concat_string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cha");
        list.add("r");
        list.add("act");
        list.add("ers");
        System.out.println(Solution.maxLength(list));
    }

    static class Solution {
        static public int maxLength(List<String> arr) {
            Set<Character> set = new HashSet<>();
            String temp = "";
            int count = 0;
            int curr_letters_count = 0;
            for (int i = 0, arrSize = arr.size(); i < arrSize; i++) {
                String s = arr.get(i);
                char[] chars = s.toCharArray();
                if (chars.length > temp.length()){
                    for (char ch: chars){
                        set.remove(ch);
                    }
                    count -= temp.length();
                }
                for (char c : chars) {
                    if (!set.add(c)) {
                        count -= curr_letters_count+1;
                        continue;
                    }
                    curr_letters_count++;
                }
                count += curr_letters_count;
                curr_letters_count = 0;
                temp = s;
            }
            return count;
        }
    }
}
