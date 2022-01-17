public class Solution {
    public int MaxProfit(int[] prices) {
        
        return OptimalApproach(prices);
    }
    
    public int OptimalApproach(int[] prices) 
    {
        int profit = 0;
        int smallestNumber = prices[0];
        
        for(int i=1; i < prices.Length; i++)
        {
            // Next number greater than smallestNumber, find the profit
            if(prices[i] > smallestNumber)
            {
                profit = Math.Max(profit, prices[i] - smallestNumber);
            }
            else
            {
                smallestNumber = prices[i];
            }
        } 
        
        return profit;
    }
    
    public int BruteForce(int[] prices) 
    {
        int profit = 0;
        
        for(int i=0; i< prices.Length; i++)
        {
            for(int j=i+1; j<prices.Length; j++)
            {
                if(prices[j] > prices[i])
                {
                    if(profit < prices[j] - prices[i])        
                        profit = prices[j] - prices[i];
                }
            }
            
        }
        
        return profit;
    }
}