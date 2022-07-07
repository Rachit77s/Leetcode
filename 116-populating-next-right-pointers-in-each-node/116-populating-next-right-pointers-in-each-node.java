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
        return Naive(root);
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
                Node currNode = q.poll();
                
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
}