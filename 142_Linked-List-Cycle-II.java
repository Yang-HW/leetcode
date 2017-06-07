/*
preparation:
meet problem in a cycle: if velocity of fast pointer is two times as fast as slow pointer,
these two pointer will meet at the starting point in the first cycle.
Prove:
At meeting point, slow steps is i, fast steps is 2i, difference is i.
If they want to meet, the fast's steps should walk 1 more cycle than the slow one.
So at this case, the total length of this cycle is i which is the distance of slow,
therefore, they will meet at starting point.
Moreover, it is obvious that i can not be more than cycle's length. If velocity of two point
are not in double relationship, same way to analyze.

For this question: for a given array, the first position of these two point meet is fixed.
Suppose slow's steps is A + B(A is the steps before the entry, B is the steps after entering the entry),
and fast's steps is 2(A + B), and difference is A + B = k * cycle's length. The meeting point is from the
entry, calculating |A - k * cycle| th point. From the meeting point, the distance of these two point to entry
is same.

Basic thought: using fast and slow pointer, do at most two times of traversal of the list.

Running time: O(n)
*/

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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
