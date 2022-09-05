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
        
        return NextPointerII(root);
    }
    
    public Node NextPointerII(Node root) 
    {
        if(root == null)
            return root;
        
        // For going level by level, top to bottom
        Node levelNode = root;
        levelNode.next = null;
        
//         // If current's right is not present, we need to find the 1st child
//         // of any other node in the same level.  
//         // Ex curr = 5, need to connect 3 to 47.
//                  15 ----> NULL
//                 /  \
//                10   13 ----> NULL
//               /    /  \
//              5    18   35 ----> NULL
//             /            \
//            3              47 ----> NULL

                     
//         // When levelNode doesn't have a left child, but has a right child.
//         // Ex, levelNode = 5
//                  15 ----> NULL
//                 /  \
//                10   13 ----> NULL
//               /    /  \
//              5    18   35 ----> NULL
//               \          
//                8          
     
                     
//         // How to bring levelNode to next level down, when level node doesn't
//         // have any left and right child?
//         // Example, need to bring levelNode = 3 to 51 i.e. connect 3 to 51.
//                  15 ----> NULL
//                 /  \
//                10   13 ----> NULL
//               /    /  \
//              5    18   35 ----> NULL
//             /    /  \    \
//            3   16    20    47 ----> NULL
//                        \     \
//                         51    63 ----> NULL           
                     
        
        while(levelNode != null)
        {
            // For moving from left to right in the same level
            Node currLevelNode = levelNode;
            
            // Move left to right in the same level, till we encounter a null
            while(currLevelNode != null)
            {
                if(currLevelNode.left != null)
                {
                    if(currLevelNode.right != null)
                        currLevelNode.left.next = currLevelNode.right;
                    else
                    {
                        // Find the 1st child of any other node in the same level
                    currLevelNode.left.next = GetRightNode1stChild(currLevelNode);
                    }
                }
                
                // currLevelNode left is null, so its right should point to
                // the 1st child of any other node in the same level
                if(currLevelNode.right != null)
                    currLevelNode.right.next = GetRightNode1stChild(currLevelNode);
                
                // Move currLevel from left to right
                currLevelNode = currLevelNode.next;
            }
            
            // When currLevelNode becomes null, we need to move to the next level
            // from top to bottom.
            // Here we will have 3 cases
            if(levelNode.left != null)
                levelNode = levelNode.left;
            else if(levelNode.right != null)
                levelNode = levelNode.right;
            else
            {
                // When both the left and right c hild of levelNode is null.
                // Find the 1st child of any other node in the same level.
                levelNode = GetRightNode1stChild(levelNode);
            }
        }
        
        return root;
    }
    
    public Node GetRightNode1stChild(Node root)
    {
        if(root == null)
            return root;
        
        // If we are passing 5 to this fn, we don't need to check for 5's children
        // we want to find the 1st child of any other node in the same level as 
        // that of 5. So we would be iterating on the children of 18 & 35
        
        Node temp = root.next;
        while(temp != null)
        {
            if(temp.left != null)
                return temp.left;
            
            if(temp.right != null)
                return temp.right;
            
            // Move from left to right
            temp = temp.next;
        }
        
        return temp;
    }
}