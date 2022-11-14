class Solution {
  
        Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
    
//     public int BruteForce(int[][] A)
//     {
//         int ans = 0;
        
//         for(int i = A.length - 1; i >= 0; i--)
//         {
//             for(int j = A.length - 2; j >= 0; j--)
//             {
//                 if(A[i][0] == A[j][0] || A[i][1] == A[j][1])
//                 {
//                     ans++;
//                     break;
                    
//                 }
//             }
//         }
        
//         return ans;
//     }
}