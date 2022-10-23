package lru_cache;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(1, 1); // cache is {1=1, 2=2}
        lRUCache.put(2, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(4, 1); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(2);    // return 3
    }

    static class LRUCache {
        private final HashMap<Integer, HashMap<Integer, Integer>> map;
        private final LinkedList<HashMap<Integer, Integer>> linked;
        private final int capacity;


        public LRUCache(int capacity) {
            linked = new LinkedList<>();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            try {
                HashMap<Integer, Integer> prev_ind = map.get(key);
                Integer res = this.linked.get(this.linked.indexOf(prev_ind)).get(key);
                this.linked.remove(prev_ind);
                this.linked.addFirst(prev_ind);
                System.out.println(res);
                return res;
            }catch (IndexOutOfBoundsException | NullPointerException e){
                System.out.println(-1);
                return -1;
            }
        }

        public void put(int key, int value) {
            HashMap<Integer, Integer> m = map.getOrDefault(key, new HashMap<>());
            if (m.size() != 0){
                this.linked.remove(m);
                m.clear();
                this.map.replace(key,m);
                m.replace(key, value);
            }else {
                m.put(key, value);
                if (capacity == this.linked.size()){
                    HashMap<Integer, Integer> last = this.linked.removeLast();
                    this.map.remove(last.entrySet().iterator().next().getKey());
                }
                this.map.put(key, m);
            }
            this.linked.addFirst(m);
        }
    }
}
