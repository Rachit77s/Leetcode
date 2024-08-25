class Solution:
    def postorderTraversal(self, root):
        result = []

        # If the root is None, return an empty list
        if not root:
            return result

        # Create a dummy node to simplify edge cases
        dummy_node = TreeNode(-1)
        dummy_node.left = root
        root = dummy_node

        # Traverse the tree
        while root:
            if root.left:  # If the current node has a left child
                predecessor = root.left

                # Find the rightmost node in the left subtree or the thread back to the current node
                while predecessor.right and predecessor.right != root:
                    predecessor = predecessor.right

                # Create a thread if it doesn't exist
                if predecessor.right == None:
                    predecessor.right = root
                    root = root.left
                else:
                    # Process the nodes in the left subtree
                    node = predecessor
                    self._reverse_subtree_links(root.left, predecessor)

                    # Add nodes from right to left
                    while node != root.left:
                        result.append(node.val)
                        node = node.right
                    result.append(node.val)  # Add root.left's value
                    self._reverse_subtree_links(predecessor, root.left)
                    predecessor.right = None
                    root = root.right
            else:
                # Move to the right child if there's no left child
                root = root.right

        return result

    def _reverse_subtree_links(self, start_node, end_node):
        if start_node == end_node:
            return  # If the start and end nodes are the same, no need to reverse

        prev = None
        current = start_node
        next = None

        # Reverse the direction of the pointers in the subtree
        while current != end_node:
            next = current.right
            current.right = prev
            prev = current
            current = next
        # Reverse the last node
        current.right = prev