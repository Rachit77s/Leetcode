class Solution {

    int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {

        // return BottomUpVideoExplanation(dungeon);
        return BottomUp(dungeon);
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
        */

        int row = A.length;
        int col = A[0].length;

        dp = new int[row][col];
        
        for(int i = row - 1; i >= 0; i--)
        {
            for(int j = col - 1; j >= 0; j--)
            {
                // Base case
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
}