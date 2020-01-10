//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode root, ListNode del) {
        ListNode prev = null;
        ListNode temp = root;
        while(temp != null && !temp.equals(del)) {
            prev = temp;
            temp = temp.next;
        }

        if(temp == null) return;
        if(temp.next == null)
            prev.next = null;
        prev.next = temp.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode aux = head;
        while(aux != null && aux.next != null) {
            if(aux.val == aux.next.val)
                 deleteNode(head, aux.next);
            else
                aux = aux.next;
        }

        return head;
    }
}
