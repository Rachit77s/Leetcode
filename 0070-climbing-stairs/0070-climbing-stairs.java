class Solution {
    public int climbStairs(int n) {
        
//         int[] dp = new int[n+1];
        
//         if(n == 1)
//             return 1;
        
//         if(n == 2)
//             return 2;
        
//         for(int i = 0; i <= n; i++)
//             dp[i] = -1;
        
//         dp[1] = 1;
//         dp[2] = 2;
        
//         for(int i = 3; i <= n; i++)
//         {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
        
//         return dp[n];
        
        
        return Optimized(n);
    }
    
    public int Optimized(int n) 
    {
        if(n == 1)
            return 1;
        
        if(n == 2)
            return 2;

        int prev = 1;
        int curr = 2;
        int next = 0;
        for(int i = 3; i <= n; i++)
        {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
}