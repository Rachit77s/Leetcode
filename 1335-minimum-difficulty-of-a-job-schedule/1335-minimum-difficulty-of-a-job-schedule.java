class Solution {
    public int minDifficulty(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;
        
        int[] dp = new int[N + 1];
        for(int i = N - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], jobDifficulty[i]);
        
        for(int d = 2; d <= D; ++d){
            for(int len = 0; len <= N - d; ++len){
                int max = 0;
                dp[len] = Integer.MAX_VALUE;
                for(int schedule = len; schedule <= N - d; ++schedule){
                    max = Math.max(max, jobDifficulty[schedule]);
                    dp[len] = Math.min(dp[len], max + dp[schedule + 1]);
                }
            }
        }
        
        return dp[0];
    }
}