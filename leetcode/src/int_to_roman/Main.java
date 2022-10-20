package int_to_roman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.intToRoman(2002));
    }


/*
*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
* */
    //99 XCIX
    //199 CXCIX
    //3999 MMMCMXCIX
    //1493 MCDXCIII
    //2022 MMXXII

    static class Solution {
        private static HashMap<Integer, List<String>> config(){
            HashMap<Integer, List<String>> map = new HashMap<>();

            for (int i = 0; i<4; i++){
                map.put(i, new ArrayList<>());
            }

            List<String> list = map.get(0);
            list.add("I");
            list.add("V");
            list.add("X");
            map.put(0, list);

            list = map.get(1);
            list.add("X");
            list.add("L");
            list.add("C");
            map.put(1, list);

            list = map.get(2);
            list.add("C");
            list.add("D");
            list.add("M");
            map.put(2, list);

            list = map.get(3);
            list.add("M");
            map.put(3, list);

            return map;
        }


        static public String intToRoman(int num) {
            HashMap<Integer, List<String>> dict = config();
//            System.out.println(getRomanDigit(200, dict));
            int digits = getRank(num);
            StringBuilder res = new StringBuilder();
            while (num != 0){
                res.append(getRomanDigit(num, dict));
                num = (int) (num % Math.pow(10, digits));
                while(getRank(num) != digits)
                {
                    digits--;
                }
            }
            return res.toString();
        }

        //returns digits after first number
        private static int getRank(int num){
            int i = 0;
            while (num > 9){
                i++;
                num /= 10;
            }
            return i;
        }
        private static String getRomanDigit(int val, HashMap<Integer, List<String>> dict){
            boolean reverse_order = false;
            StringBuilder roman_symbols = new StringBuilder();
            int digits = getRank(val);
            List<String> list = dict.get(digits);
            if(val > 9){
                val = (int) (val / Math.pow(10, digits));
            }


            while (val !=0 ){
                if (val == 4){
                    val += 2;
                    reverse_order = true;
                }
                else if (val < 4) {
                    roman_symbols.append(list.get(0));
                    val -=1;
                }
                else if (val < 9){
                    roman_symbols.append(list.get(1));
                    val = val - 5;
                }
                else {
                    roman_symbols.append(list.get(2));
                    val -= 8;
                    reverse_order = true;
                }
            }

            if (reverse_order) {
                char[] chars = roman_symbols.toString().toCharArray();
                roman_symbols = new StringBuilder();
                for (int i = chars.length-1;i>=0; i--){
                    roman_symbols.append(chars[i]);
                }
            }
            return roman_symbols.toString();
        }
    }
}
