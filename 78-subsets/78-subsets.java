class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        BacktrackV1(ans, new ArrayList<Integer>(), 0, nums);
        
        return ans;
    }
    
    // This method will 1st print empty array []
    void BacktrackV2(List<List<Integer>> ans, List<Integer> tempList, int index, int[] nums)
    {
        if(index == nums.length)
        {
            ans.add(new ArrayList<>(tempList));    
            return;
        }
        
        // Not take the element
        BacktrackV2(ans, tempList, index + 1, nums);
        
        // Take the element
        tempList.add(nums[index]);
        BacktrackV2(ans, tempList, index + 1, nums);
        // Remove the recently added element
        tempList.remove(tempList.size() - 1);

    }
    
    // This method will 1st print [1,2,3]
    void BacktrackV1(List<List<Integer>> ans, List<Integer> tempList, int index, int[] nums)
    {
        if(index == nums.length)
        {
            ans.add(new ArrayList<>(tempList));    
            return;
        }
        
        // Take the element
        tempList.add(nums[index]);
        BacktrackV1(ans, tempList, index + 1, nums);
        
        // Not take the element
        tempList.remove(tempList.size() - 1);
        BacktrackV1(ans, tempList, index + 1, nums);
    }
    
    
}