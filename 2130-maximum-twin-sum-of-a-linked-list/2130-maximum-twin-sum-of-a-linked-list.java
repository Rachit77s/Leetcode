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
    public int pairSum(ListNode head) {
        
        // Using 2 pointer approach
        
        // Find mid
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse
        ListNode curr = slow;
        ListNode next = null;
        ListNode prev = null;
        
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode start = head;
        ListNode end = prev;
        int ans = Integer.MIN_VALUE;
        
        while(end != null)
        {
            ans = Math.max(ans, start.val + end.val);
            start = start.next;
            end = end.next;
        }
        
        return ans;
    }
}