/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
