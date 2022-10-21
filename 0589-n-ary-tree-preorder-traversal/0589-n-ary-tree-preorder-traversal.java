/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        
        return RecursiveHelper(root);
    }
    
    public List<Integer> RecursiveHelper(Node root) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        Recursive(root, ans);
        return ans;
    }
    
    public void Recursive(Node root, List<Integer> ans) 
    {
        if(root == null)
            return;
        
        ans.add(root.val);
        
        for(Node node: root.children)
            Recursive(node, ans);        
    }
}