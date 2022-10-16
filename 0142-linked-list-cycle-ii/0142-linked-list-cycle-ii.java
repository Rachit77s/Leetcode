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
        
        return M2(head);
        // return M1(head);
    }
    
    // Striver: https://www.youtube.com/watch?v=QfbOhn0WZ88
    public ListNode M1(ListNode head)
    {
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode entryPointer = head;
        
        // Find if the loop exists
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            // loop exists
            if(slow == fast)
            {
                // find the start point of the cycle
                while(slow != entryPointer)
                {
                    slow = slow.next;
                    entryPointer = entryPointer.next;
                }
            
                return slow;
            }
        }
        
        return null;
    }
    
    // Anuj: https://www.youtube.com/watch?v=jcZtMh_jov0
    public ListNode M2(ListNode head)
    {
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode entryPointer = head;
        
        // Find if the loop exists
         while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                break;
        }
        
        if(slow != fast)
        {
            //NO LOOP
            return null;
        }    
        else if(slow == fast)
        {
            // Detect first node of the meeting point
            while(slow != entryPointer)
            {
                slow = slow.next;
                entryPointer = entryPointer.next;
            }
            
            return slow;
        }

        return null;
    }
}