/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode insertLast(ListNode node, int x) {
        ListNode aux = node;
        if(node == null) return new ListNode(x);
        while(aux.next != null) {
            aux = aux.next;
        }
        aux.next = new ListNode(x);
        return node;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rez = null;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                //rez = new ListNode(l1.val);
                rez = insertLast(rez, l1.val);
                l1 = l1.next;
            } else {
//                rez = new ListNode(l2.val);
                rez = insertLast(rez, l2.val);
                l2 = l2.next;
            }
        }

        while(l1 != null) {
//            rez = new ListNode(l1.val);
            rez = insertLast(rez, l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
//            rez = new ListNode(l2.val);
            rez = insertLast(rez, l2.val);
            l2 = l2.next;
        }

        return rez;
    }
}
