package insert_delete_get_random_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        System.out.println(param_1);
        boolean param_2 = obj.remove(2);
        System.out.println(param_2);
        boolean param_3 = obj.insert(2);
        System.out.println(param_3);
        int param_4 = obj.getRandom();
        System.out.println(param_4);
        boolean param_5 = obj.remove(1);
        System.out.println(param_5);
        boolean param_6 = obj.insert(2);
        System.out.println(param_6);
        int param_7 = obj.getRandom();
        System.out.println(param_7);

    }

    static class RandomizedSet {
        private HashMap<Integer, Integer> map;
        private List<Integer> list;
        private Random rand;



        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if(!map.containsKey(val)){
                list.add(val);
                map.put(val, list.size()-1);
                return true;
            }
            else {
                return false;
            }
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int idx = map.get(val);
                list.remove(idx);
                map.remove(map.get(val));
                return true;
            }
                return false;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
