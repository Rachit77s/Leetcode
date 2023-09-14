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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        return ReverseInKGroup(head, k);
    }
    
    // https://www.youtube.com/watch?v=znQ8wJxnRao&ab_channel=CodeLibrary-byYogesh%26Shailesh
    public ListNode ReverseInKGroup(ListNode head, int k) 
    {
        int count = k;
        
        ListNode iterator = head;
        for(int i = 0; i < count; i++)
        {
            if(iterator == null)
                return head;
            
            iterator = iterator.next;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null && k != 0)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        // Check for next because it is pointing to the upcoming node
        // Whereas if would have used prev, it would be wrong.
        // Dry run this
        if(next != null)
            head.next = ReverseInKGroup(next, count);
        
        return prev;
    }
}