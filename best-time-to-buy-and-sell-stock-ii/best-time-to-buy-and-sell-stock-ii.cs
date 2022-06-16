public class Solution {
    public int MaxProfit(int[] prices) {
        
        int minValue = 0;
        int ans = 0;
        
        minValue = prices[0];
        //[7,1,5,3,6,4]
        // for(int i=1; i<prices.Length; i++)
        // {
        //     if(prices[i] < minValue)
        //     {
        //         minValue = prices[i];
        //     }
        //     else
        //     {
        //         ans += prices[i] - minValue;
        //     }
        // }
        
        for(int i=0; i< prices.Length-1; i++)
        {
            if(prices[i] < prices[i+1])
            {
                ans += prices[i+1] - prices[i];
            }
        }
        
        return ans;
        
    }
}