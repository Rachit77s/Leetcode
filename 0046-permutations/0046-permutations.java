class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Recurse(nums, ans, 0);
        return ans;
    }
    
    public void Recurse(int[] A, List<List<Integer>> ans, int index)
    {
        if(index == A.length)
        {
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i = 0;i < A.length; i++)
                list.add(A[i]);
            
            ans.add(list);
            return;
        }
        
        for(int i = index; i < A.length; i++)
        {
            Swap(A, index, i);
            Recurse(A, ans, index + 1);
            Swap(A, index, i);
        }
    }
    
    public void Swap(int[] A, int start, int end)
    {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}