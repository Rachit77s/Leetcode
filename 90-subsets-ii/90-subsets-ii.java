class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
//          LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>( Arrays.asList(nums) );
         
//         //Get back the array without duplicates
//         Integer[] numbersWithoutDuplicates = linkedHashSet.toArray(new Integer[] {});
        
        HashSet<List<Integer>> hset = new HashSet<List<Integer>>();        
        Backtrack(list, new ArrayList<>(), nums, 0, hset);
        
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
        
  
        
        // case 2 : Don't pick the element ( notice, we did not add the current element in our temporary list
        Backtrack(list, tempList, nums, index+1, hset); // move ahead
        
        // Main logic
		// Case 1 : Take/Pick the element
        tempList.add(nums[index]);
        Backtrack(list, tempList, nums, index+1, hset); // move ahead
        // Remove recently added element
        tempList.remove(tempList.size()-1);
        
		// case 2 : Don't pick the element ( notice, we did not add the current element in our temporary list
        //Backtrack(list, tempList, nums, index+1, hset); // move ahead
    }
}