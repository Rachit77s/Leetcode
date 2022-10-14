class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = Integer.MAX_VALUE - 1;
        
        dp[0] = 0;
        
        for(int i = 0; i< n; i++)
        {
            for(int j = i+1; j < n && j <= i + nums[i]; j++)
            {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        
        // for(int i = 0; i < n; i++)
        //     System.out.print(dp[i] + " ");
        
        return dp[n-1];
    }
}