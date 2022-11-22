class Solution {
    public int numSquares(int n) {
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[0] = 0;
        // for(int i = 1; i <= n; ++i) {
        //     int min = Integer.MAX_VALUE;
        //     int j = 1;
        //     while(i - j*j >= 0) {
        //         min = Math.min(min, dp[i - j*j] + 1);
        //         ++j;
        //     }
        //     dp[i] = min;
        // }		
        // return dp[n];
        
        return DPHelper(n);
    }
    
    public int DPHelper(int n)
    {
        // Class question Satya Sai
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        // Greedy approach won't work
        
        for(int i = 1; i <= n; i++)
        {
            int min = Integer.MAX_VALUE;
            
            for(int j = 1; j * j <= i; j++)
            {
                min = Math.min(min, 1 + dp[i - j * j]);
            }
            
            dp[i] = min;
        }
        
        return dp[n];
    }
}