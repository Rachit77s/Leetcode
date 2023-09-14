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
        
        return ReverseInKGroupIterative(head, k);
    }
    
    // Subham: https://www.scaler.com/help_requests/827697/
    public ListNode ReverseInKGroupIterative(ListNode head, int k) 
    {
        /*
            Idea is to save the 1st element of Kth group in a list,
            while saving break the links as well
            Afterwards reverse the list having LinkedList element
            Finally join the reversed elements
        
        */
        if(head == null || head.next == null || k == 1)
            return head;
        
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head);
        
        ListNode prev = null;
        ListNode curr = head;
        int index = 0;
        
        // Iterate and store every 1st element in the list
        // Ex: 1 3 5
        while(curr != null)
        {
            if(prev != null && index % k == 0)
            {
                // Break the link
                prev.next = null;
                list.add(curr);
            }
            
            prev = curr;
            curr = curr.next;
            index += 1;
        }
        
        // Reverse and update the reversed node as new head
        for(int i = 0; i < list.size(); i++)
        {
            ListNode ll = list.get(i);
            
            // If the length is K then only reverse
            if(GetLength(ll) == k)
            {
                ListNode newHead = Reverse(ll);
                list.set(i, newHead);
            }     
        }
        
        // Join the LL's
        for(int i = 0; i < list.size() - 1; i++)
        {
            ListNode prevLlEndNode = list.get(i);
            
            // Get to the end node of the curr LL
            while(prevLlEndNode.next != null)
                prevLlEndNode = prevLlEndNode.next;
            
            // Make the link
            prevLlEndNode.next = list.get(i+1);
        }
            
        return list.get(0);
    }
    
    public ListNode Reverse(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        
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
    
    public int GetLength(ListNode head) 
    {
        int length = 0;   
        ListNode curr = head;
        
        while(curr != null)
        {
            curr = curr.next;
            length++;
        }
        
        return length;
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