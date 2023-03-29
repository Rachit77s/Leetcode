class Solution {
    public int maxSatisfaction(int[] A) {
        
        return TopDownRecursionHelperFunction(A);
    }
    
    
    // Babbar: https://www.youtube.com/watch?v=_iGlRDLPLxM
    public int TopDownRecursionHelperFunction(int[] A) 
    {
        // Question is similar to include/exclude approach
        // Similar to Knapsack
        
        // Sort the array
        Arrays.sort(A);
        
        int index = 0;
        
        int[][] dp = new int[A.length + 1][A.length + 1];
        
        for(int i = 0; i <= A.length; i++)
        {
            for(int j = 0; j <= A.length; j++)
            {
                dp[i][j] = -1;
            }
        }
        
        int time = 1;
        return TopDownRecursion(A, index, time, dp);
    }
    
    public int TopDownRecursion(int[] A, int index, int time, int[][] dp) 
    {
        if(index == A.length)
            return 0;
        
        if(dp[index][time] != -1)
            return dp[index][time];
        
        int include = A[index] * (time) + 
                    TopDownRecursion(A, index + 1, time + 1, dp);
        
        int exclude = TopDownRecursion(A, index + 1, time, dp);
        
        return dp[index][time] = Math.max(include, exclude);
    }
    
    /*
        [-1,-2,-3,5,2] --> [-3,-2,-1,2,5]
        [-10,-80,100,5]
        [-100,-8,25]
    */
    
    // faster
    // https://www.youtube.com/watch?v=mB24wDI0Bp0
//     public int Approach2(int[] A) 
//     {
        
//     }
}



