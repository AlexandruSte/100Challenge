//https://leetcode.com/problems/merge-k-sorted-lists/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode response = new ListNode(0), tail = response;
        for(ListNode l: lists) {
            if(l != null)
                queue.add(l);
        }

        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null) {
                queue.offer(tail.next);
            }
        }

        return response.next;
    }
}



//solutia initiala
class MergeKLists {
        private ListNode insertLast(ListNode root, int val) {
            if (root == null) return new ListNode(val);
            ListNode aux = root;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = new ListNode(val);

            return root;
        }

        public ListNode merge(ListNode node, ListNode root) {
            ListNode aux = node;
            ListNode temp = root;
            ListNode ret = null;
            while (aux != null && temp != null) {
                if (aux.val > temp.val) {
                    ret = insertLast(ret, temp.val);
                    temp = temp.next;
                } else {
                    ret = insertLast(ret, aux.val);
                    aux = aux.next;
                }
            }

            while (aux != null) {
                ret = insertLast(ret, aux.val);
                aux = aux.next;
            }

            while (temp != null) {
                ret = insertLast(ret, temp.val);
                temp = temp.next;
            }

            return ret;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            ListNode response = null;
            for (ListNode l : lists) {
                response = merge(response, l);
            }
            return response;
        }
    }
