package merge_two_sorted_list;

public class Main {
    public static void main(String[] args) {
        Solution.ListNode list1 = new Solution.ListNode(-9, new Solution.ListNode(3));
        Solution.ListNode list2 = new Solution.ListNode(5, new Solution.ListNode(7));
        Solution.ListNode list = Solution.mergeTwoLists(list1, list2);
        System.out.println();
    }
    static class Solution {
        public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}

            ListNode(int val) { this.val = val; }

            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode res = new ListNode();
            ListNode temp = res;
            boolean flag1 = false;

            if (list1 == null && list2 == null){
                return null;
            }

            while (list1!=null || list2!= null){
                if (list1 != null && list2 != null){
                    if (list1.val < list2.val){
                        res.val = list1.val;
                        list1 = list1.next;
                    }
                    else
                    {
                        res.val = list2.val;
                        list2 = list2.next;
                    }
                    res.next = new ListNode();
                    res = res.next;
                } else {
                    if (list1 != null){
                        res.val = list1.val;
                        list1 = list1.next;
                        if (list1!= null){
                            res.next = new ListNode();
                            res = res.next;
                        }
                    } else {
                        res.val = list2.val;
                        list2 = list2.next;
                        if (list2!= null){
                            res.next = new ListNode();
                            res = res.next;
                        }
                    }
                }
            }
            return temp;
        }
    }
}
