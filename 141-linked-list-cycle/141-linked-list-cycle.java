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

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/773/discuss/1829489/C++-oror-Easy-To-Understand-oror-2-Pointer-oror-Fast-and-Slow
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Slow fast pointers
        
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // till fast and fast-> next not reaches NULL
		// we will increment fast by 2 step and slow by 1 step
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)    // Loop exists
                break;
        }
        
        if(slow != fast)
            return false;
        else
            return true;
    }
}