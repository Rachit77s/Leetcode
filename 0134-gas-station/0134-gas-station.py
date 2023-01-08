class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         int total_surplus = 0;
//         int surplus = 0;
//         int start = 0;
        
//         for(int i = 0; i < n; i++){
//             total_surplus += gas[i] - cost[i];
//             surplus += gas[i] - cost[i];
//             if(surplus < 0){
//                 surplus = 0;
//                 start = i + 1;
//             }
//         }
//         return (total_surplus < 0) ? -1 : start;
        
        return Helper1(gas, cost);
    }
    
    // Neetcode: https://www.youtube.com/watch?v=lJwbPZGo05A
    // Alisha: https://www.youtube.com/watch?v=MWTHTDIBN0s
    public int Helper1(int[] gas, int[] cost)
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

// 2 3 4
// 3 4 3

// 4 5 1 2 3    
// 1 2 3 4 5