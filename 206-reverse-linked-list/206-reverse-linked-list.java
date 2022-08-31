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
        
        return Recursive(head);
    }
    
    public ListNode Recursive(ListNode head) 
    {
        // 1 -> 2 -> 3 -> 4
        // 
        // Think of the last step
        // At end we have 4, now we will need to attach 3 to node 4.
        // 3   4 --> X   , here 3 would be head, and 4 would be head.next
        // 4 <-- 3
        // Now 4 would be, head.next.next = head
        
        if(head == null || head.next == null)
            return head;
        
        ListNode chotaHead = Recursive(head.next);
        head.next.next = head;
        head.next = null;
        return chotaHead;
    }
    
    public ListNode Iterative(ListNode head) 
    {
        return head;
    }
}