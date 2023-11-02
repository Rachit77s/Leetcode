# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node:
                return [0, 0, 0]
            left = dfs(node.left)
            right = dfs(node.right)
            nodes_count = left[0] + right[0] + 1
            subtree_sum = left[1] + right[1] + node.val
            nodes_equal_to_root = left[2] + right[2] + (subtree_sum // nodes_count == node.val)
            return [nodes_count, subtree_sum, nodes_equal_to_root]
        return dfs(root)[2]