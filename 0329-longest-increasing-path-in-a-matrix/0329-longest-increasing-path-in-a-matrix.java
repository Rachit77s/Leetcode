class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        return longestIncreasingPathHelper(matrix);
    }
    
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPathHelper(int[][] A)
    {
        if(A.length == 0) 
            return 0;
        
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        
        int max = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(A, i, j, m, n, dp);
                max = Math.max(max, len);
            }
        }
        
        return max;
    }
    
    public int dfs(int[][] A, int i, int j, int m, int n, int[][] dp)
    {
        if(dp[i][j] != 0) 
            return dp[i][j];
        
        int max = 1;
        
        for(int[] dir: dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(0 <= x && x < m && 0 <= y && y < n && A[x][y] > A[i][j])
            {
                int len = 1 + dfs(A, x, y, m, n, dp);
                max = Math.max(max, len);
            }
            else
                continue;
        }
        
        dp[i][j] = max;
        return max;
    }
}