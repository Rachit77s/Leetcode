class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        //int currentSum = 0;
        
        for(int i=0; i<nums.length; i++)
        {
            //currentSum += nums[i];
            
            if(map.containsKey(target - nums[i]))
            {
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }
            
            map.put(nums[i], i);
        }
        
        return new int[2];
    }
}