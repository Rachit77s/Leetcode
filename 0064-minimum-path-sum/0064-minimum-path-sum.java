class Solution {
    
    int[][]dp;
    public int minPathSum(int[][] grid) {
        
        return BottomUpOne(grid);
        
        // return TopDownHelper(grid);
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
    
    public int BottomUpOne(int[][] A)
    {
        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];

        dp[0][0] = A[0][0];

        for (int i = 1; i < row; i++)
            dp[i][0] = A[i][0] + dp[i-1][0];

        for (int j = 1; j < col; j++)
            dp[0][j] = A[0][j] + dp[0][j - 1];


        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
            {
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[row - 1][col - 1];
    }

    public int BottomUpTwo(int[][] A)
    {
        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];

        dp[0][0] = A[0][0];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (i == 0 && j > 0)
                {
                    dp[0][j] = A[0][j] + dp[0][j - 1];
                }
                else if(j == 0 && i > 0)
                {
                    dp[i][0] = A[i][0] + dp[i - 1][0];
                }
                else if(i > 0 && j > 0)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
                
            }
        }

        return dp[row - 1][col - 1];
    }
    
}