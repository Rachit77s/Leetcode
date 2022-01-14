public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        
        return HelperTwoSum(nums, target);
    }
    
    public int[] HelperTwoSum(int[] nums, int target) 
    {
        if(nums.Length < 2)
        {
            int[] k = {-1,-1};
            return k;
        }    
        
        
        Dictionary<int, int> dict = new Dictionary<int, int>();
        
        for(int i=0; i<nums.Length; i++)
        {
            int complement = target - nums[i];
            
            if(dict.ContainsKey(complement))
            {
                int[] ans = new int[2];
                ans[0] = dict[complement];
                ans[1] = i;
                
                return ans;
            }
            // IMP condition 
            else if(!dict.ContainsKey(nums[i]))
            {
                dict.Add(nums[i], i);
            }
        }
        
        return null;
    }
}