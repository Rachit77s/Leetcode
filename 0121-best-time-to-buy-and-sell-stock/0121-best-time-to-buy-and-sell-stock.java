class Solution {
    public int maxProfit(int[] prices) {
          
        return KadaneAlgoApproach(prices);
        //return OptimalApproach(prices);
        //return BruteForce(prices);
    }
    
    public int KadaneAlgoApproach(int[] prices)
    {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++)
        {
            minPrice  = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
        
        // Aliter
        // int minTillNow = prices[0], maxTillNow = 0;
        // for(int i = 0; i < prices.size(); i++){
        //     maxTillNow = max(maxTillNow, prices[i] - minTillNow);
        //     minTillNow = min(minTillNow, prices[i]);
        // }
        // return maxTillNow;
    }
    
    public int OptimalApproach(int[] prices) 
    {
        int profit = 0;
        int smallestNumber = prices[0];
        
        for(int i=1; i < prices.length; i++)
        {
            // Next number greater than smallestNumber, find the profit
            if(prices[i] > smallestNumber)
            {
                profit = Math.max(profit, prices[i] - smallestNumber);
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
        
        for(int i=0; i< prices.length; i++)
        {
            for(int j=i+1; j<prices.length; j++)
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