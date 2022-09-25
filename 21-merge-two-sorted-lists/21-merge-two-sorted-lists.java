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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return IterativeWitDummyNode(list1, list2);
    }
    
    public ListNode IterativeWitDummyNode(ListNode list1, ListNode list2) 
    {
        if(list1 == null) 
            return list2;
        
        if(list2 == null) 
            return list1;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        //        0     1 -> 3
        //              2 -> 4
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else
            {
                curr.next = list2;
                list2 = list2.next;
            }
            
            curr = curr.next;
        }
        
        // We have reach end of the list
        if(list1 != null)
            curr.next = list1;
        
        if(list2 != null)
            curr.next = list2;
        
        return dummy.next;
    }
    
    public ListNode IterativeWithoutDummy(ListNode list1, ListNode list2) 
    {
        if(list1 == null) 
            return list2;
        
        if(list2 == null) 
            return list1;
        
        // Find out the head node
        ListNode tempHead = list1;
        
        if(list1.val < list2.val)
        {
            list1 = list1.next;
        }
        else
        {
            tempHead = list2;
            list2 = list2.next;
        }
        
        ListNode curr = tempHead;
        
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else
            {
                curr.next = list2;
                list2 = list2.next;
            }
            
            curr = curr.next;
        }
        
        if(list1 != null)
            curr.next = list1;
        
        if(list2 != null)
            curr.next = list2;
        
        return tempHead;
    }
    
    public ListNode RecursiveSolution(ListNode list1, ListNode list2) 
    {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val<list2.val)
        {
            list1.next = RecursiveSolution(list1.next, list2);
            return list1;
        }
        else
        {
            list2.next = RecursiveSolution(list2.next, list1);
            return list2;
        }
    }
    
}