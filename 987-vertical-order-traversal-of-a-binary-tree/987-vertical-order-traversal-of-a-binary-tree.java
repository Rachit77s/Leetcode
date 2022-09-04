/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
          TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        // Get from map
        map.get(x).get(y).offer(root.val);
        
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
        
    }
//         return UsingRecursion(root, 0, new TreeMap<Integer, List<Integer>>());
//     }
    
//     public List<List<Integer>> UsingRecursion(TreeNode root, int dist, TreeMap<Integer, List<Integer>> map) 
//     {
//         List<List<Integer>> ans = new ArrayList<>();
        
//         if(root == null)
//             return ans;
        
//         map.putIfAbsent(dist, new ArrayList<Integer>());
//         map.get(dist).add(root.val);
        
//         UsingRecursion(root.left, dist - 1, map);
//         UsingRecursion(root.right, dist + 1, map);
        
//         for (Map.Entry<Integer, List<Integer>> ee : map.entrySet()) 
//         {
//             Integer key = ee.getKey();
//             List<Integer> values = ee.getValue();
            
//             Collections.sort(values);
//             ans.add(values);
//         }
        
//         return ans;    
//     }
}