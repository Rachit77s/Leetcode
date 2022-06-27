class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList();
        List<Integer> currComb = new ArrayList();
        Combination(candidates, 0, target, currComb, ans);
        return ans;
    }
    
    void Combination(int[] A, int index, int target, 
                     List<Integer> currComb,  List<List<Integer>> ans)
    {
        if(index == A.length)
        {
            // target becomes zero at any point, we found a possible combination
            if(target == 0)
            {
                ans.add(new ArrayList<>(currComb));
            }
            return;
        }
        
        // If target becomes less than zero, then simply return, saying that no it is not possible to our target combination sum
        if(target < 0)
            return;
        
        if(A[index] <= target)
        {
            // Including ith element
            currComb.add(A[index]);
            
            // Decreasing sum,and call function again 
            Combination(A, index, target - A[index], currComb, ans);    
                
            // Backtrack
            currComb.remove(currComb.size() - 1);
        }
        
        // We are not taking the ith element,
        // So without decreasing sum we will move to next index because it will not contribute in making our sum
        Combination(A, index + 1, target, currComb, ans);
    }
}