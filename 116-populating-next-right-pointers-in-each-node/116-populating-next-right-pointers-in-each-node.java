/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
            
        // return Naive(root);
        // return Recursive(root);
        // return Recursive(root);
        return Optimized(root);
    }
    
    // T.C.: O(N), S.C: O(N)
    public Node Naive(Node root)
    {
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0)
        {
            int levelSize = q.size();
            
            for(int i=0; i < levelSize; i++)
            {
                Node currNode = q.remove();
                
                if(i == levelSize - 1)
                    currNode.next = null;
                else
                    currNode.next = q.peek();
                
                if(currNode.left != null)
                     q.add(currNode.left);
                
                if(currNode.right != null)
                     q.add(currNode.right);
                    
            }
        }
        
        return root;
    }
    
    // T.C.: O(N), S.C: O(N) 
    public Node Recursive(Node root)
    {
        if(root == null)
            return null;
        
        // Connect the left subtree of same level with right subtree of that same level 
        if(root.left != null)
            root.left.next = root.right;
        
        // Connect the rightmost node of a level to the leftmost node of the next level.
        // Stand at node 2 and think about node 5 & 6
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;
        
        Recursive(root.left);
        Recursive(root.right);
        
        return root;
    }
    
    public Node Optimized(Node root) 
    {
        if (root == null) 
            return root;
        
        Node prev = root;   // Think of it as current level
        Node curr = null;
        
        while(prev != null)
        {
            curr = prev;    // Curr level
            
            while(curr != null && curr.left != null)
            {
                 // connect next pointer of curr left node to the right node
                if(curr.left != null)
                    curr.left.next = curr.right;
                
                if(curr.right != null && curr.next != null)
                    curr.right.next = curr.next.left;
                
                // move to right next node in current level
                curr = curr.next;
            }
            
            // move to next level
            prev = prev.left;
        }
        
        return root;
    }
}