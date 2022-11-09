package reverse_linked_list;

public class Main {
    public static void main(String[] args) {
        Solution.ListNode list = new Solution.ListNode(1,new Solution.ListNode(2, new Solution.ListNode(3)));
        Solution.ListNode res = Solution.reverseLinkedList(list);
        System.out.println(res);
    }
    static class Solution {
        public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}

            ListNode(int val) { this.val = val; }

            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        static public ListNode reverseLinkedList(ListNode list) {
            ListNode l;
            if (list!= null) {
                list = list.next;
                l = new ListNode(reverseLinkedList(list).val);
                return l;
            }
            else {
                return null;
            }
        }
    }
}
