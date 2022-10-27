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
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        return DFSHelper(root);
    }
    
    public String DFSHelper(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        DFS(root, sb);
        
        return sb.toString();
    }
    
    public void DFS(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append(NN).append(spliter);
            return;
        }
        
        sb.append(root.val).append(spliter);
        
        DFS(root.left, sb);
        DFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        return DFSDeserializeHelper(data);
    }
    
    public TreeNode DFSDeserializeHelper(String data)
    {
        String[] node = data.split("[,]");
        int[] index = new int[1];
        
        return DFSDeserialize(node, index);
    }
    
    public TreeNode DFSDeserialize(String[] node, int[] index)
    {
        // if(index[0] == node.length)
        //     return null;
        
        if(node[index[0]].equals(NN))
        {
            index[0]++;
            return null;
        }
        
        
        TreeNode root = new TreeNode(Integer.valueOf( node[ index[0] ] ));
        index[0]++;
        
        root.left = DFSDeserialize(node, index);
        root.right = DFSDeserialize(node, index);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));