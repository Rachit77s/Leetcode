class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        return MinCostBottomUp(triangle);
    }
    
    public int BottomUpApproachGoingFromTopToBottom(List<List<Integer>> a)
    {
        int rows = a.size();
        int cols = a.get(a.size() - 1).size();  // Last row columns
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = a.get(0).get(0);


        for (int i = 1; i < rows; ++i) 
        {
            for (int j = 0; j <= i; ++j) 
            {
                if(j == 0)
                    dp[i][0] = a.get(i).get(j) + dp[i-1][j];
                else   
                    dp[i][j] = a.get(i).get(j) + Math.min( dp[i - 1][j], dp[i - 1][j - 1] );
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = cols-1; j >= 0; --j) 
        {
            // System.out.print(dp[rows - 1][j]);
            // System.out.print("  ");
            ans = Math.min(ans, dp[rows - 1][j]);
        }

        return ans;
    }
    
    public int MinCostBottomUp(List<List<Integer>> a) 
    {
        int rows = a.size();
        int cols = a.get(a.size() - 1).size();  // Last row columns
        int[][] dp = new int[rows][cols];
        
        // Fill the last row of dp array
        for(int j = 0; j < cols; j++)
        {
            dp[rows - 1][j] = a.get(rows - 1).get(j);
        }
        
        // Iterate from 2nd last row to the top
        for(int i = rows - 2; i >= 0; i--)
        {
            for(int j = 0; j < a.get(i).size(); j++)
            {
                dp[i][j] = a.get(i).get(j) + Math.min( dp[i+1][j], dp[i+1][j+1] );
            }
        }
        
        return dp[0][0];
    }
}