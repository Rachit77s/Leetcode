class Solution {
    public int maxProfit(int[] prices) {
        
        int ans = 0;
        int minElement = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            if(minElement > prices[i])
                minElement = prices[i];
            else
                ans = Math.max(ans, prices[i] - minElement);
        }
        
        return ans;
    }
}