/*
82. Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

Solution1:
Basic Idea: using two pointers, when element is different from the former one and the later one, it can
be removed, so we just need to compare it with former and later.
Trick: this method doesnot suit for the first one and the last one. So for the first ones
we should add a fake head before it, and return fake.next as a result. For the last one, we
should judge it seperatly.

Solution2:
Basic idea: using two pointer, the fast pointer use to find the last duplicate element, if cur pointer
equal to the fast, the fast is only one element, if not, change these two pinter's position and do it
again.

solution2 is more clean and concise.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = new ListNode(Integer.MAX_VALUE);
        ListNode result = slow;
        slow.next = head;
        ListNode fast = head;
        int pre = slow.val;
        while(fast.next != null){
            if (fast.val != pre && fast.val != fast.next.val){
                slow.next = fast;
                slow = slow.next;
            }
            pre = fast.val;
            fast = fast.next;
        }
        if (fast.val != pre) {
            slow.next = fast;
            slow = slow.next;
        }
        slow.next = null;
        return result.next;
    }
}

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(Integer.MAX_VALUE);
        ListNode pre = fake;
        ListNode cur = head;
        pre.next = cur;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return fake.next;
    }
}
