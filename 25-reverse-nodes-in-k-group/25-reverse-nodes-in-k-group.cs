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
        
        return reverseKGroupThree(head, k);

        //return ReverseKOne(head, k);
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
    
    // Wrong output
    public ListNode ReverseKTwo(ListNode head, int k) 
    {
        Stack<ListNode> stk = new Stack<ListNode>();
        ListNode current = head;
        ListNode prev = null;
        
        while (current != null)
        {
            int count = 0;
            while (current != null && count < k)
            {
                stk.Push(current);
                current = current.next;
                
                if(current == null)
                    return head;
                
                count++; 
            }
            
            while (stk.Count > 0)
            {
                if(prev == null)
                {
                    prev = stk.Peek();
                    head = prev;
                    stk.Pop();
                }
                else
                {
                    prev.next = stk.Peek();
                    prev = prev.next;
                    stk.Pop();
                }
            }
        }
        
        prev.next = null;
        return head;
    }
    
    public static ListNode reverseKGroupThree(ListNode head, int k)
    {
        // https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iterator = dummy;

        while (iterator != null)
        {
            ListNode node = iterator;

            // First check whether there are k nodes to reverse
            for (int i = 0; i < k && node != null; i++)
            {
                node = node.next;
              
            }

            // Check this breaking condition
            if (node == null)
            {
                break;
            }
            
            ListNode curr = iterator.next;
            ListNode prev = null;
            ListNode next = null;

            for (int i = 0; i < k; i++)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 0 (pointer) -> 1 <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
            ListNode tail = iterator.next;
            tail.next = curr;
            iterator.next = prev;
            iterator = tail;
        }

        return dummy.next;
    }

}