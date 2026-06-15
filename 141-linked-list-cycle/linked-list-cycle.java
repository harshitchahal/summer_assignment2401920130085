/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode runner = head;
        ListNode walker = head;

        while (runner != null && runner.next != null) {

            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner) {
                return true;
            }
        }

        return false;
    }
}