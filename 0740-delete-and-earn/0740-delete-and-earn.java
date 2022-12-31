class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] freq = new int[10001];
        
        // Max score we can get by deleting ith number
        int[] dp = new int[10001];
        
        for(int i = 0; i < nums.length; i++)
            freq[nums[i]]++;
        
        dp[1] = freq[1];
        dp[2] = Math.max(dp[1], 2 * freq[2]);
        
        for(int i = 3; i < 10001; i++)
        {
            int take = i * freq[i] + dp[i-2];
            int notTake = dp[i-1];
            
            dp[i] = Math.max(take, notTake);
        }
        
        return dp[10000];
    }
}