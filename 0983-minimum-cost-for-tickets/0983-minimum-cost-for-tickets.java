class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        if(days==null || days.length==0)
            return 0;
        
        int n = days.length;
        
        int[] dp = new int[days.length+1];
        
        return func(days, costs, n, 0, dp);
    }
    
    public int func(int[] days, int[] costs, int n, int idx, int[] dp)
    {
        if(idx >= n)
            return 0;
        
        if(dp[idx] != 0)
            return dp[idx];
        
        int a = costs[0] + func(days, costs, n, idx + 1, dp);
        int i;
        for(i=idx; i<n && days[i]<days[idx]+7;i++);
        int b=costs[1]+func(days, costs, n, i, dp);
        for(i=idx;i<n && days[i]<days[idx]+30;i++);
        int c=costs[2]+func(days, costs, n, i, dp);
        
        dp[idx]=Math.min(a, Math.min(b, c));
        
        return dp[idx];
            
    }
}