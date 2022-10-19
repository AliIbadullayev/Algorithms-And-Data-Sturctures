package valid_polindrome;

public class Main {
    public static void main(String[] args) {
        String s =  "an_a";
        System.out.println(Solution.isPalindrome(s));
    }

    static class Solution {
        static public boolean isPalindrome(String s) {
            s = normalize(s);
            System.out.println(s);
            char[] chars = s.toCharArray();
            if (chars.length == 0 )
                return true;
                for (int i = 0; i < chars.length/2; i++){
                    if (chars[i]!=chars[chars.length-i-1]){
                        return false;
                    }
                }
            return true;
        }

        private static String normalize(String s){
            return s.toLowerCase().replaceAll("\\s","").replaceAll("\\W","").replaceAll("_","");
        }
    }
}
