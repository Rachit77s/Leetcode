# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.minDistance = 1e9
        # Initially, it will be null.
        self.prevNode = None
        
        def inorder(root):
            if root is None:
                return
            
            inorder(root.left)
            
            if self.prevNode is not None:
                self.minDistance = min(self.minDistance, root.val - self.prevNode)
            
            self.prevNode = root.val
            
            inorder(root.right)
            
        inorder(root)
            
        return self.minDistance