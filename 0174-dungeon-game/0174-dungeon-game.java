class Solution {

    int[][] dp;

    // https://leetcode.com/problems/dungeon-game/discuss/1500016/Why-can't-you-go-from-top-left-to-bottom-right-Explained
    public int calculateMinimumHP(int[][] dungeon) {

        return BottomUpVideoExplanation(dungeon);
        // return BottomUp(dungeon);
    }
    
    // https://www.youtube.com/watch?v=lSOsKhQc_VI&ab_channel=Codebix
    public int BottomUp(int[][] A)
    {
        // dp[i]: Min health that we must have before stepping into
        // the (i,j) cell if we want to reach the princess.
        // For ex, if we are at (2,0) and princess is (2,2) then from (2,0) 
        // what is the min health I require to reach (2,2)

        /*
            Observations:
            1. For +ve number the min health needed is 1, and 
               for -ve value the min health needed is => Abs(A[i][j]) + 1

               For example,
                I/P: [3] 
                Only 1 element which is +ve, so min health required to enter this cell
                is x + 3 i.e it should be 1 since 3 is +ve and we need min health.
                
                I/P: [-10]
                This is -ve case, so min health req to enter this cell is 
                x + (-10) and this should be >= 1, so x + (-10) = 1 
                x => 11
                
            At any point if our health gets zero of below we dies, so : we need 1 + (-mat[i][j]) for our health to be one.
        */

        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];
        
        for(int i = row - 1; i >= 0; i--)
        {
            for(int j = col - 1; j >= 0; j--)
            {
                // Base Case : we have reached our destination ie. last cell
                if(i == row - 1 && j == col - 1)
                {
                    if(A[i][j] > 0)
                        dp[i][j] = 1;
                    else
                        {
                            // x + A[i][j] = 1;
                            // x = 1 - A[i][j];
                            dp[i][j] = 1 - A[i][j];
                        }

                    // Aliter
                    // dp[i][j] = Math.max((1-A[i][j]),1);
                }
                // Last row
                else if(i == row - 1)
                    dp[i][j] = Math.max(1, dp[i][j+1] - A[i][j]);
                // Last col
                else if(j == col - 1)
                    dp[i][j] = Math.max(1, dp[i+1][j] - A[i][j]);
                else
                {
                    // dp[i][j] = Math.max( ( Math.min(dp[i+1][j], dp[i][j+1] )  - A[i][j]), 1);
                    // min of either values and then cost of this cell
                    // totalHealthValue - presentCellValue
                    int heathValue = Math.min(dp[i+1][j], dp[i][j+1]) - A[i][j];
                    
                    if(heathValue <= 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = heathValue;
                }
                    
            }
        }
        
        return dp[0][0];
    }
    
    public int BottomUpVideoExplanation(int[][] A)
    {
        // https://leetcode.com/problems/dungeon-game/discuss/52790/My-AC-Java-Version-Suggestions-are-welcome
        
        int row = A.length;
        int col = A[0].length;

        // If the matrix is of 2x2, then create dp matrix of 3x3 because
        // we will fill the one greater row and col of 2x2 matrix with 1, to help with base case.
        dp = new int[row + 1][col + 1];

        // Very imp to initialise matrix with infinity
        // If we don't do that, consider when index is 2,2, loop will go to pick value from cell (3,1) & (2,2)
        // And we will get wrong ans due to this. 
        // Got this issue after dry run
        for (int[] m : dp) 
            Arrays.fill(m, Integer.MAX_VALUE);


        // If matrix is 2x2, then fill the extra row and col(3,3) to cover the base case.
        // Fill bottom and right col of the final cell 2x2.
        // Bottom cell would be [3][2] and right cell would be [2][3].
        
        // Bottom Cell
        dp[row][col - 1] = 1;
        // Right cell
        dp[row - 1][col] = 1;

        for (int i = row - 1; i >= 0; i--)
        {
            for (int j = col - 1; j >= 0; j--)
            {
                // min of either values and then cost of this cell
                // Final value till now - current cell value
                int val = Math.min(dp[i+1][j], dp[i][j+1]) - A[i][j];

                if(val <= 0)
                    dp[i][j] = 1;   // This means curr value was +ve, hence, we don't need extra energy
                else
                    dp[i][j] = val;
            }
        }
        
        return dp[0][0];
    }
}