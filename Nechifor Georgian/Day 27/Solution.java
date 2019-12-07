
// * Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode t = this;
        while(t.next != null) {
            s.append(t.val).append(" -> ");
            t = t.next;
        }
        s.append(t.val);
        return s.toString();
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rez = l1;
        int carry = 0;
        while(l2 != null) {
            rez.val += l2.val + carry;
            carry = rez.val / 10;
            rez.val = rez.val % 10;
            l2 = l2.next;
            if(l2 != null && rez.next == null) rez.next = new ListNode(0);
            rez = rez.next;

        }
        while(rez != null) {
            rez.val +=  carry;
            carry = rez.val / 10;
            rez.val = rez.val % 10;

            rez = rez.next;
        }
        if(carry != 0) {
           ListNode aux = l1;
           while(aux.next != null)
               aux = aux.next;
           aux.next = new ListNode(carry);
        }
        return l1;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        Solution s = new Solution();

//        System.out.println(l1);
//        System.out.println(l2);
        System.out.println(s.addTwoNumbers(l1, l2));
    }
}
