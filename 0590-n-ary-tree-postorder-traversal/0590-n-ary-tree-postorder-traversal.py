class Solution:
    def postorder(self, root: "Node") -> List[int]:
        result = []
        # If the root is None, return the empty list
        if root is None:
            return result

        node_stack = [(root, False)]

        while node_stack:
            current_node, is_visited = node_stack.pop()

            if is_visited:
                # If the node has been visited, add its value to the result
                result.append(current_node.val)
            else:
                # Mark the current node as visited and push it back to the stack
                node_stack.append((current_node, True))

                # Push all children to the stack in reverse order
                for child in reversed(current_node.children):
                    node_stack.append((child, False))

        return result
    