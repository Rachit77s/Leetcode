# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        def pre(node):
            if not node:
                return

            # Append the current node's value to the string
            self.ans += str(node.val)

            # If the current node has a left child or a right child, include parentheses
            if node.left or node.right:
                self.ans += "("
                pre(node.left)  # Recursive call to process the left subtree
                self.ans += ")"

            # If the current node has a right child, include parentheses
            if node.right:
                self.ans += "("
                pre(node.right)  # Recursive call to process the right subtree
                self.ans += ")"

        self.ans = ""  # String to store the final string representation
        pre(root)  # Call the helper function to construct the string
        return self.ans  # Return the final string representation of the tree