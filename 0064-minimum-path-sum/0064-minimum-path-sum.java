class Solution {
    
    int[][]dp;
    public int minPathSum(int[][] grid) {
        
        return TopDownHelper(grid);
    }

    public int TopDownHelper(int[][] A)
    {
        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                dp[i][j] = -1;
            }
        }
            
        return (int) TopDown(A, row - 1, col - 1);    
    }

    public int TopDown(int[][] A, int i, int j)
    {
        if(i < 0 || j < 0)
            return Integer.MAX_VALUE;
        else if(i == 0 && j == 0)
            return dp[i][j] = A[i][j];
        else if(dp[i][j] != -1)
            return dp[i][j];
        else 
            return dp[i][j] = A[i][j] + 
                              Math.min(TopDown(A, i-1, j), TopDown(A, i, j-1));
    }
    
}