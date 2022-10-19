package string_compression;

public class Main {
    public static void main(String[] args) {
        char[] chars = {'a','c'};
        System.out.println(Solution.compress(chars));
//        System.out.println(((int) ((char)1+48)));
    }

    static class Solution {
        static public int compress(char[] chars) {
            int times = 0;
            char current_letter = 0;
            int counter = 0;

            if (chars.length == 1){
                return 1;
            }

            for (int i=0; i< chars.length; i++){
                if (current_letter == chars[i] ) times++;
                if (current_letter != chars[i]) {
                    if (i != 0) {
                        counter = getCounter(chars, times, current_letter, counter);
                        counter++;
                    }
                    current_letter = chars[i];
                    times = 1;
                }
                if (i == chars.length-1){
                    counter = getCounter(chars, times, current_letter, counter);
                    times = 1;
                    counter++;
                    current_letter = chars[i];
                }

            }

            return counter;
        }

        private static int getCounter(char[] chars, int times, char current_letter, int counter) {
            if (times == 1) {
                chars[counter] = current_letter;
            } else if (times < 10) {
                chars[counter++] = current_letter;
                chars[counter] = (char) (times + 48);
            } else {
                chars[counter++] = current_letter;
                int digits = 0;
                int copy_times = times;

                while (copy_times != 0) {
                    copy_times = copy_times / 10;
                    digits++;
                }

                counter = counter + digits - 1;
                while (times != 0) {
                    chars[counter--] = (char) (times % 10 + 48);
                    times = times / 10;
                }
                counter = counter + digits;
            }
            return counter;
        }
    }
}
