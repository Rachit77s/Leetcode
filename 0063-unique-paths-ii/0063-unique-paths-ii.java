class Solution {
        
    int[][] dp;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        return BottomUp(obstacleGrid);
    }
    
    public int BottomUp(int[][] A)
    {
        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];
        
        // Logical error I made: If 0,2 is blocked then we cant go to 0,3 as well, 
        // so it will be 0, instead of 1.
        if (A[0][0] == 1)
        {
            dp[0][0] = 0;
        }
        else
        {
            dp[0][0] = 1;
        }
        
        // Dry Run code, you will understand.
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if(A[i][j] == 1)
                {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i > 0)
                    dp[i][j] += dp[i-1][j];
                
                if(j > 0)
                    dp[i][j] += dp[i][j-1];
            }
        }
        
        return dp[row-1][col-1];
    }

    // TLE
    public int HelperTopDown1(int[][] A)
    {
        // Clarifying Example to consider in this below matrix of 3x3
        // 0 0 0
        // 1 1 1
        // 0 0 0 
        // No of ways to reach to the end is 0
        
        // Obstacle is 1 

        int row = A.length;
        int col = A[0].length;
        
        dp = new int[row][col];
        
        // {1, 0};      // 0 row (0,1) col
        return TopDown1(A, row - 1, col - 1);
    }
    
    public int TopDown1(int[][] A, int i, int j)
    {
        // If initial starting point is not an obstacle 1
        if(i == 0 && j == 0 && A[i][j] == 0)
            return dp[i][j] = 1;
        // First check for index out of bound
        else if(i < 0 || j < 0)
            return 0;
        else if(A[i][j] == 1)
            return dp[i][j] = 0;
        
        // Obstacle already accounted in the base case
        return dp[i][j] = TopDown1(A, i-1, j) + TopDown1(A, i, j-1);
    }
    
    // TLE    // Kshitij DP 2
    public int HelperTopToDown(int[][] A)
    {        
        // Assumption: Total ways to reach (n, m) from bottom and right
        int row = A.length;
        int col = A[0].length;
        
        dp = new int[row + 1][col + 1];
        
        // {1, 0};      // 0 row (0,1) col
        return TopToDown(A, 0, 0, row, col);
    }
    
    public int TopToDown(int[][] A, int i, int j, int row, int col)
    {       
        // If the end point is not an obstacle 1
        if(i == row - 1 && j == col - 1 && A[i][j] == 0)
        {
            return dp[i][j] = 1;
        }
        // First check for index out of bound
        else if(i >= row || j >= col)
        {
            return 0;
        }
        // Cell is a obstacle
        else if(A[i][j] == 1)
        {
            return dp[i][j] = 0;
        }
        
        // Obstacle already accounted in the base case
        return dp[i][j] = TopToDown(A, i+1, j, row, col) + TopToDown(A, i, j+1, row, col);
    } 
}