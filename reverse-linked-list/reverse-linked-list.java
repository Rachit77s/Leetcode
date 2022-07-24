/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null)
            return null;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null)
        {
            next = curr.next;       // n = 2 --> 1.n = 2    3
            curr.next = prev;       // 1.n = null     2 -> 1
            prev = curr;            //   2
            curr = next;
        }
        
        return prev;
    }
}