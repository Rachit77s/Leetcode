class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        return climbStairs(cost);
    }
    
    public int climbStairs(int[] cost) 
    {
        int twoStepBefore = cost[0];
        int oneStepBefore = cost[1];
        int curr = 0;
        for(int i = 2;i< cost.length;i++){
            curr = Math.min(twoStepBefore,oneStepBefore) + cost[i];
            twoStepBefore = oneStepBefore;
            oneStepBefore = curr;
        }
        
        return Math.min(oneStepBefore,twoStepBefore);
    }
}