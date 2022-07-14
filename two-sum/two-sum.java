class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        int[] result = new int[2];
        
        // [2,7,11,15], target = 9
        for(int i=0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                 result[0] = i;
                // Index of the other element of the pair
                result[1] = map.get(target - nums[i]);
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        
        return result;
    }
}