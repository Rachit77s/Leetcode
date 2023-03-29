class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        return Helper1(satisfaction);
        // return RecursionHelper(satisfaction);
    }
    
    public int RecursionHelper(int[] A) 
    {
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
        
        return TopDownRecursion(A, index, 0, dp);
    }
    
    public int TopDownRecursion(int[] A, int index, int time, int[][] dp)
    {
        if(index == A.length)
            return 0;
        
        if(dp[index][time] != -1)
            return dp[index][time];
        
        int include = A[index] * (time+1) + TopDownRecursion(A, index + 1, time + 1, dp);
        
        int exclude = TopDownRecursion(A, index + 1, time, dp);
        
        return dp[index][time] = Math.max(include, exclude);
    }
    
    public int Helper1(int[] A) 
    {
        Arrays.sort(A);
        
        int currSum = 0;
        int startIdx = A.length - 1;
        
        for(int i = A.length - 1; i >= 0; i--)
        {
            currSum += A[i];
            
            if(currSum < 0)
                break;
            
            startIdx--;
        }
        
        startIdx++;
        
        int time = 1;
        
        int ans = 0;
        for(int i = startIdx; i < A.length; i++)
        {
            ans += A[i] * time;
            time++;
        }
        
        return ans;
    }
}

// -1 -2 -3 5 2

/*

[-1,-2,-3,5,2]

[-3,-2,-1,2,5] : 23     25+8-3-4-3

[-10,-80,100,5]: -80-20+15+400
[-100,-8,25]

*/