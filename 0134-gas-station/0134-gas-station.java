class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        return OptimizedHelper(gas, cost);
        // return BruteForce(gas, cost);
    }

    // https://www.youtube.com/watch?v=xWgbFI_rXJs&ab_channel=NareshGupta
    public int BruteForce(int[] gas, int[] cost) 
    {
        int n = gas.length;
        
        for(int i = 0; i < n; i++)
        {
            int totalGas = 0;
            int j = i;
            int counter = 0;
            
            if(gas[i] - cost[i] >= 0)
            {
                while(counter < n)
                {
                    totalGas += gas[j % n] - cost[j % n];
                    
                    if(totalGas < 0)
                        break;
                    
                    counter++;
                    j++;
                }
                
                if(counter == n && totalGas >= 0)
                    return i;
            }
        }
        
        return -1;
    }
    
        
    // Neetcode: https://www.youtube.com/watch?v=lJwbPZGo05A
    // Alisha: https://www.youtube.com/watch?v=MWTHTDIBN0s
    public int OptimizedHelper(int[] gas, int[] cost)
    {
        // Check if the solution even exists
        int sum = 0;
        for(int i = 0; i < gas.length; i++)
            sum = sum + gas[i] - cost[i];
        
        if(sum < 0)
            return -1;
        
        // Solution exists, let's find it.
        int startIndex = 0;
        int remainingFuel = 0;
        for(int i = 0; i < gas.length; i++)
        {
            remainingFuel = remainingFuel + gas[i] - cost[i];
            
            if(remainingFuel < 0)
            {
                startIndex = i + 1;
                remainingFuel = 0;
            }
        }
        
        return startIndex;  
    }
}