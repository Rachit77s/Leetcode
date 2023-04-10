/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Codec {

    private static final String spliter = ",";
    private static final String NN = "X";
    
    // https://www.scaler.com/help_requests/686140/?ref=join-call-now
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        return DFSHelper(root);    
    }
    
    public String DFSHelper(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        DFS(root, sb);
        
        System.out.print(sb);
        return sb.toString();
    }
    
    public void DFS(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append(NN);
            sb.append(spliter);
            return;
        }
        
        sb.append(root.val);
        sb.append(spliter);
        
        DFS(root.left, sb);
        DFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
         return DFSDeserializeHelper(data);
    }
    
    public TreeNode DFSDeserializeHelper(String data)
    {
        String[] str = data.split(",");
        //System.out.println();
        
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < str.length; i++)
            queue.add(str[i]);
        
        return DFSDeserialize(queue);
    }
    
    public TreeNode DFSDeserialize(Queue<String> queue)
    {
        if(queue.isEmpty())
            return null;
        
        String str = queue.poll();
            
        if(str.equals(NN))
        {
            return null;
        }
            
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = DFSDeserialize(queue);
        root.right = DFSDeserialize(queue);        
        
        return root;
    }

}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));