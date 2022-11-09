package number_of_recent_calls;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    class RecentCounter {
        private List<Integer> array;
        public RecentCounter() {
            array = new ArrayList<>();
        }

        public int ping(int t) {
            int leftSide = t - 3000;
            array.add(t);
            int count = 0;
            for (int i = array.size()-1; i >= 0; i--){
                if (array.get(i) < leftSide){
                    array.remove(i);
                    break;
                }else
                {
                    count++;
                }
            }
            return count;
        }
    }
}
