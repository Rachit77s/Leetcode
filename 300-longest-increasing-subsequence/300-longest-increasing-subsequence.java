class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
    
    public int LIS(int[] A)
    {
        if (A == null || A.length == 0) 
            return 0;

        int[] dp = new int[A.length];
        
        for (int i = 0; i < A.length; i++)
            dp[i] = 1;
        
        // Handled edge case, if u are using ans = 0, then start below loop frm 0
        int ans = 1;
        
        for(int i = 1; i < A.length; i++)
        {
            // dp[i] = 1;
            // Iterate over all j less than i
            for(int j = 0; j < i; j++)
            {
                // If ith element is greater than the jth element, 
                // then only compute the LIS
                if(A[i] > A[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}