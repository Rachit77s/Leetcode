class Solution {
    
    int[][] dp;
    
    public int minFallingPathSum(int[][] matrix) {
        
        
        /*
            1. What is the element of choice?
            2. Can we solve the problem using Recursion?
            3. What is the Recursion Relation?
            4. What is the Base Case?
            5. Does the problem has Overlapping Subproblems?
                     a. What is the DP array's size or the number of states?
                     b. What does DP[i] denotes?
                     c. What is the DP expression?
                     d. What is the final answer state?

            7 Steps of DP
            1. What is the element of choice?
                Can we solve the problem using Recursion?
                 What is the Recursion Relation?
                  Verify if it has Optimal Substructure and Overlapping Subproblems
            2.  What is the DP state? i.e. dp[i] ?
            3.  What is the DP expression?
            4.  What does the DP table contains or it's capacity?
            5.  What is the DP code base condition?
            6.  Write the DP code
            7.  Figure out the TC and SC.
            8.  Optimization in SC
        */
        
        
        // return Approach1(matrix);
        return StriverApproachHelper(matrix);
    }
    
    public void Notes()
    {
        /*
            
            dp[i]: min path sum to reach (i,j) from any cell in the 1st row.
            
            For last row each col figure out the min path sum.
            F(n-1,0) F(n-1,1) F(n-1,2)
            
            Start from n-1 row and reach to 0th row
        */
    }
    
    public int Approach1(int[][] A)
    {
        //dp[i]: Tells us the min path at any idx
        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++)
        {
            dp[0][i] = A[0][i];
        }
        // dp[0][0] = A[0][0];

        for (int i = 1; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (j == 0)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == col - 1)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], 
                                         Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
            }
        }

        for(int i = 0; i < A.length; i++)
        {
            if(dp[A.length-1][i] < min)  min = dp[A.length-1][i];
        }
        return min;
    }
    
    // Striver: https://www.youtube.com/watch?v=N_aJ5qQbYA0
    public int StriverApproachHelper(int[][] A)
    {
        /*
            7 Steps of DP
            2.  What is the DP state? i.e. dp[i] ?

            dp[i]: Min path sum to reach (i,j) last row each col from any cell
            in the 1st row.
        */
        
        int result = Integer.MAX_VALUE;
        
        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];

        for(int[] currRow : dp) 
            Arrays.fill(currRow, Integer.MAX_VALUE);
        
        for(int j = 0; j < col; j++)
            result = Math.min(result, StriverApproachMemoization(A, row - 1, j));
        
        return result;
    }
    
    public int StriverApproachMemoization(int[][] A, int i, int j)
    {   
        if(j < 0 || j >= A[i].length)
            return Integer.MAX_VALUE;
            
        if(i == 0)
            return dp[0][j] = A[0][j];
        
        if(dp[i][j] != Integer.MAX_VALUE) 
            return dp[i][j];

        int up = StriverApproachMemoization(A, i - 1, j);
        int left = StriverApproachMemoization(A, i - 1, j - 1);
        int right = StriverApproachMemoization(A, i - 1, j + 1);
        
        return dp[i][j] = Math.min(Math.min(left, right), up) + A[i][j];
    }
}