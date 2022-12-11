class Solution {
    
    int[][] dp;
    
    public int uniquePaths(int m, int n) {
        
        return BottomUp(m, n);
        // return TopDownHelper(m, n);
    }
    
    // We can reach last cell from top cell or left cell
    public int TopDownHelper(int m, int n)
    {
        dp = new int[m][n];
        
        // Fill each row with -1
        // for (int[] row: dp)
        //     Arrays.fill(row, -1);
        
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
    
    public int BottomUp(int i, int j)
    {
        dp = new int[i][j];
        
        // Fill 1st row
        for(int r = 0; r < i; r++)
            dp[r][0] = 1;
        
        // Fill 1st col
        for(int c = 0; c < j; c++)
            dp[0][c] = 1;
        
        // Fill remaining cells
        for (int r = 1; r < i; r++) 
        {
          for (int c = 1; c < j; c++) 
          {
              dp[r][c] = dp[r-1][c] + dp[r][c-1];
          }
        }
        
        return dp[i-1][j-1];
    }
}