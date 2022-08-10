public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(9));
        ListNode l2 = new ListNode(1,new ListNode(2));
        Solution solution = new Solution();

        ListNode summ = solution.addTwoNumbers(l1, l2);
        return;
    }
}


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode small;
        ListNode big;
        ListNode result = new ListNode();
        ListNode tempResult = result;
        int memory = 0;
        int sum = 0;

        if (smallestOne(l1, l2) == 1) {
            small = l1;
            big = l2;
        } else {
            small = l2;
            big = l1;
        }

        while (big != null) {
            if (small != null) {
                sum = small.val + big.val + memory;
            } else {
                sum = big.val + memory;
            }

            if (sum > 9) {
                result.val = sum % 10;
                memory = 1;
            } else {
                result.val = sum;
                memory = 0;
            }

            if (small != null) {
                if (small.next != null)
                    small = small.next;
                else
                    small = null;
            }

            big = big.next;

            if (big != null) {
                result.next = new ListNode();
                result = result.next;
            }

            if (memory == 1 && big == null){
                result.next = new ListNode();
                result = result.next;
                result.val = 1;
            }
        }
        return tempResult;
    }

    public int smallestOne(ListNode l1, ListNode l2){
        int sizeL1=0;
        int sizeL2=0;
        sizeL1 = listSize(l1);
        sizeL2 = listSize(l2);
        return sizeL1<sizeL2?1:2;
    }

    public int listSize(ListNode l){
        int size=0;

        while (l != null){
            size++;
            l = l.next;
        }
        return size;
    }
}