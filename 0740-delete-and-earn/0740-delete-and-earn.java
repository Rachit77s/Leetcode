class Solution {
    public int deleteAndEarn(int[] nums) {
        
//         int[] freq = new int[10001];
        
//         // Max score we can get by deleting ith number
//         int[] dp = new int[10001];
        
//         for(int i = 0; i < nums.length; i++)
//             freq[nums[i]]++;
        
//         dp[1] = freq[1];
//         dp[2] = Math.max(dp[1], 2 * freq[2]);
        
//         for(int i = 3; i < 10001; i++)
//         {
//             int take = i * freq[i] + dp[i-2];
//             int notTake = dp[i-1];
            
//             dp[i] = Math.max(take, notTake);
//         }
        
//         return dp[10000];
        
        
        return ApproachI(nums);
    }
    
    // https://leetcode.com/problems/delete-and-earn/discuss/109871/Awesome-Python-4-liner-with-explanation-Reduce-to-House-Robbers-Question
    // https://leetcode.com/problems/delete-and-earn/discuss/109891/Sharing-my-Simple-Straight-Forward-Java-O(n)-Solution-Explanation-Included
    public int ApproachI(int[] nums)
    {
        /*
            Observation: This ques is similar to House Robber
            
            We first transform the nums array into a values/dp array that sums up 
            the total number of points for that particular value. 
            A value of x will be assigned to index x in points.

            The condition that we cannot pick adjacent values is similar to 
            the House Robber question that we cannot rob adjacent houses. 
            Simply pass points into the rob function for a quick win \U0001f31d!

            nums:   [2, 2, 3, 3, 3, 4] (2 appears 2 times, 3 appears 3 times, 4 appears once)
         dp/values: [0, 0, 4, 9, 4] <- This is the gold in each house!
         
         
            The idea is a simple trick. 
            Notice that at every element, you have 2 choices: 
            To earn or not to earn. 
            Based on problem, whichever element you earn, you must delete 
            any values of nums[i]-1 and nums[i]+1. 
            It helps to assume a sorted array so that you can place elements 
            in ascending order to visualize the problem. You notice there that 
            if you earn an element, you cannot earn its immediate unequal neighbors 
            on both sides.


            You also notice that if you have duplicate values in nums array, 
            if you earn one of them, you end up earning all of them. 
            This is because you have deleted its neighbors and therefore make 
            its remaining duplicates "undeletable". This is important because 
            you notice the problem simplifies to which values can earn you the largest total.

            So added the sums into a sums array to map each value(array's index) 
            with the total sum we can earn by deleting all elements of 
            that value (array's value). Then write a for loop to compute 
            the max sum ending at i At each step, your sum can either depend on your 
            previous sum or the prior plus the current. 
            You use a greedy algorithm to always pick the maximum value for each i.

            *** Notice that when you create sums array, it naturally orders (sorts) 
            the elements for you in ascending order so you can traverse it and 
            get its immediate unequal neighbors on both sides in O(1).

        */
        
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];

        int RANGE = 10000;
        int[] dp = new int[RANGE + 1];
        
        // sums or values array containing the total value of that element
        for(int n : nums)
            dp[n] += n;
     
        //index 0 house is not used, -> 0
        //index 1 is just the value in dp[1]
        int max = dp[1];
        for(int i = 2; i < RANGE + 1; i++)
        {
            // Take alternate houses
            int take = dp[i] + dp[i-2];
            int skip = dp[i-1];
            
            dp[i] = Math.max(take, skip);
        }
        
        return dp[RANGE];
    }
}