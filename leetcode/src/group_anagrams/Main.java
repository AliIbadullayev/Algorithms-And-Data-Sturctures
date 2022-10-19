package group_anagrams;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(Solution.groupAnagrams(strs));

    }
    static class Solution {
        static public List<List<String>> groupAnagrams(String[] strs) {
            //counter of groups
            int count = 0;
            //word that be template (according to this word will find anagrams)
            List<Character> current_word;
            //word that will be checked with template word
            List<Character> sub_word;
            HashMap<List<Character>, List<String>> dict = new HashMap<>();

            for (String s : strs) {
                current_word = addWord(s);
                Collections.sort(current_word);
                dict.put(current_word, new ArrayList<>());

            }

            for (String str : strs) {
                current_word = addWord(str);
                Collections.sort(current_word);
                List<String> arr = dict.get(current_word);
                arr.add(str);
                dict.put(current_word, arr);
            }

            return new ArrayList<>(dict.values());
        }
        private static List<Character> addWord( String s){
            List<Character> word = new ArrayList<>();
            for (char c: s.toCharArray()){
                word.add(c);
            }
            return word;
        }
    }
}
