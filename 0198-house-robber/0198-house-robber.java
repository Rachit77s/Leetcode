class Solution {
    public int rob(int[] nums) {
//         if (nums.length == 0) return 0;
//         int prev1 = 0;
//         int prev2 = 0;
//         for (int num : nums) {
//             int tmp = prev1;
//             prev1 = Math.max(prev2 + num, prev1);
//             prev2 = tmp;
//         }
//         return prev1;
        
        return BottomUp(nums);
    }
    
    public int BottomUp(int[] A) 
    {
        int n = A.length;
        // dp state: max amount from o to ith index
        int[] dp = new int[n];
        
        dp[0] = A[0];
        
        if(n <= 1)
            return dp[0];
        
        dp[1] = Math.max(A[0], A[1]);
        
        for(int i = 2; i < n; i++)
        {
            dp[i] = Math.max(dp[i-1], (A[i] + dp[i-2]));
        }
        
        return dp[n-1];
    }
}