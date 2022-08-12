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
    public boolean isPalindrome(ListNode head) {
        
        return StriverHelper(head);
        // return Helper(head);
    }
    
    public boolean Helper(ListNode head) 
    {
        // Love Babbar: https://www.youtube.com/watch?v=aD7mBVnKFEU
        
        /*
            Steps:
            1. Find the middle element of the LL
            2. Reverse the list 
            3. Compare both the halves of the LL
            4: Make the LL back to original LL i.e. reverse 2nd half again(OPTIONAL STEP)
        */
        
        if(head == null || head.next == null)
            return true;
        
        // 1. Find the middle element
        ListNode middle = GetMiddle(head);
        
        // 2. Reverse the list after the middle element
        // This is important step, notice the fast pointer initialisation in this approach
        ListNode temp = middle.next;
        middle.next = Reverse(temp);      
            
        // 3. Compare both the halves of the LL
        ListNode head1 = head;
        ListNode head2 = middle.next;    
            
        while(head2 != null)
        {
            if(head2.val != head1.val)
                return false;
            
            head2 = head2.next;
            head1 = head1.next;
        }
            
        // 4: Make the LL back to original LL i.e. reverse 2nd half again(OPTIONAL STEP)
        temp = middle.next;
        middle.next = Reverse(temp);
        
        return true;
    }
    
    public boolean StriverHelper(ListNode head) 
    {
        if(head == null || head.next == null)
            return true;      
        
        // Striver GetMiddle function
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the right half
        slow.next = Reverse(slow.next);
        // Move slow to right half
        slow = slow.next;
        
        ListNode head1 = head;
        ListNode head2 = slow;   
            
        while(head2 != null)
        {
            if(head2.val != head1.val)
                return false;
            
            head2 = head2.next;
            head1 = head1.next;
        }

        return true;
    }
    
    public ListNode GetMiddle(ListNode head) 
    {
        ListNode slow = head;
        // Notice fast pointer initialisation
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode Reverse(ListNode head) 
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

// 1 --> 2 --> 2 --> 1
// 1 --> 2 --> 3 --> 2 --> 1
// 1 --> 2 --> 2 --> 3 --> 2 --> 2 --> 1

// 1. Put in Array 1 2 2 1