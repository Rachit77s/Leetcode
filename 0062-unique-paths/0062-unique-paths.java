class Solution {
    
    int[][] dp;
    
    public int uniquePaths(int m, int n) {
        
        
        return TopDownHelper(m, n);
    }
    
    // We can reach last cell from top cell or left cell
    public int TopDownHelper(int m, int n)
    {
        dp = new int[m][n];
        
        return TopDownRecursion(m-1, n-1);
    }
    
    public int TopDownRecursion(int i, int j)
    {
        if(i == 0 || j == 0)
            return 1;
        
        if(dp[i][j] > 0)
            return dp[i][j];
        
        dp[i][j] = TopDownRecursion(i-1, j) + TopDownRecursion(i, j-1);
        
        return dp[i][j];
    }
    
    
}