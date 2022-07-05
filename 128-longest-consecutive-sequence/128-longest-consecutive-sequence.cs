public class Solution {
    public int LongestConsecutive(int[] nums) {
        return Better(nums);
    }
    
    public int Better(int[] nums)
    {
        if (nums.Length == 0) {
            return 0;
        }
        
        Array.Sort(nums);
        
         // 1 2 3 4 100 200
            
        //  0  1 2 3 4 5 6 7 8 9 10  
        // -1 -1 0 1 3 4 5 6 7 8 9
            
        int ans = 1;
        int maxLength = 1;
        
        for(int i=0; i<nums.Length-1; i++)
        {
            if (nums[i] != nums[i+1])
            {
                if(nums[i+1] == nums[i] + 1)
                {
                    maxLength++;
                    ans = Math.Max(ans, maxLength);
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