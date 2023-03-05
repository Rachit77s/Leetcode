class Solution {
    public int consecutiveNumbersSum(int N) {

        
        // Pepcoding: https://www.youtube.com/watch?v=EiC2eIlYu_w\
        
        int ans = 0;
        
        // Get upper bound of K
        for(int K = 1; 2 * N > K * (K-1); K++) 
        {
            int numerator = N - (K * (K-1) / 2);
            
            if(numerator % K == 0)
                ans++;
        }
        
        return ans;
    }
}

// 5