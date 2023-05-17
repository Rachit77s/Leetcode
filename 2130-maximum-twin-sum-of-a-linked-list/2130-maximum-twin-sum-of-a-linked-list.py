# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        
        # Get middle of linked list
        slow , fast = head, head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        
        # Reverse second part of linked list
        curr = slow
        next, prev = None, None
        while curr != None:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            
        # Get max sum of pairs
        maxVal = 0
        while(prev != None):
            maxVal = max(maxVal, head.val + prev.val)
            head = head.next
            prev = prev.next
            
        return maxVal