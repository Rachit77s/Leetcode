class Solution {
    public int longestConsecutive(int[] nums) {
        return Better(nums);
    }
    
     public int Better(int[] nums)
     {
         if (nums.length == 0) 
         {
            return 0;
         }

         int maxLength = 1;
         int ans = 1;
         Arrays.sort(nums);
         
         // [0, -3, 5, -1, 7, -2, -4, 1, 3], Output: 6
         //  0  1  2  3 4 5 6 7
         // -4 -3 -2 -1 0 1 2 3 
         for (int i = 0; i < nums.length - 1; i++)
         {
             if(nums[i] != nums[i+1])
             {
                 if(nums[i + 1] == nums[i] + 1)
                 {
                     maxLength++;
                     ans = Math.max(ans, maxLength);
                 }
                 else
                 {
                     maxLength = 1;
                 }
             }
         }
         
         return ans;
     }
}