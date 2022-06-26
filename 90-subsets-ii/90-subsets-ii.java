class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        
        // Edge Case: {2,1,2} will print duplicates
        Arrays.sort(nums);
        
        HashSet<List<Integer>> hset = new HashSet<List<Integer>>();        
        Backtrack(list, new ArrayList<>(), nums, 0, hset);
        
        // Approach: Without using HashSet 
        //Backtrack2(list, new ArrayList<>(), nums, 0);
        
        return list;
    }
    
    private void Backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int index, HashSet<List<Integer>> hset)
    {
        if(index == nums.length)
        {
            if(hset.contains(tempList))
            {  
                //Do nothing
            }         
            else
            {
                hset.add(tempList);
                list.add(new ArrayList<>(tempList));  
            }  
            
            return;
        }
              
        // Main logic
		// Case 1 : Take/Pick the element
        tempList.add(nums[index]);
        Backtrack(list, tempList, nums, index+1, hset); // move ahead
        // Remove recently added element
        tempList.remove(tempList.size()-1);
        
        // case 2 : Don't pick the element ( notice, we did not add the current element in our temporary list
        Backtrack(list, tempList, nums, index+1, hset); // move ahead
    }
    
    // Neetcode video
    private void Backtrack2(List<List<Integer>> list , List<Integer> tempList, int [] nums, int index)
    {
        if(index == nums.length)
        {           
            list.add(new ArrayList<>(tempList));  
            return;
        }
        
		// Case 1 : Take/Pick the element
        tempList.add(nums[index]);
        Backtrack2(list, tempList, nums, index+1); // move ahead
        // Remove recently added element
        tempList.remove(tempList.size()-1);
        
        // To handle duplicate case, skip the duplicated element.
        // {1,2,2,3,2}
        while(index + 1 < nums.length && nums[index] == nums[index + 1])
            index = index + 1;
        
        // case 2 : Don't pick the element ( notice, we did not add the current element in our temporary list
        Backtrack2(list, tempList, nums, index+1); // move ahead
    }
    
}