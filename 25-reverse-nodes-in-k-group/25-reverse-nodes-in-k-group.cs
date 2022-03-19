/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseKGroup(ListNode head, int k) {
     
        /*
            Traverse linked list from left to right, during traverse, group nodes in k, 
            then reverse each group.
        */
        
        return ReverseKOne(head, k);
    }
    
    // https://www.youtube.com/watch?v=znQ8wJxnRao&ab_channel=CodeLibrary-byYogesh%26Shailesh
    public ListNode ReverseKOne(ListNode head, int k) 
    {
        ListNode iterator = head;
        
        for(int i = 0; i < k; i++)
        {
            if(iterator == null)
                return head;
            
            iterator = iterator.next;
        }
        
        // [1,2,3,4,5,6,7,8], k = 3
        // head = 1     4   7
        // next = 4     7
        // prev = 3     6   8
        
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        
        int count = 0;
        
        while(curr != null && count < k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;    
        }
        
        // Next would be pointer to K+1th node
        if(next != null)
            head.next = ReverseKOne(next, k);
        
        return prev;
    }
}