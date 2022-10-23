class Solution {
    public int[] findErrorNums(int[] nums) {

        return Helper1(nums);
    }
    
    public int[] Helper1(int[] A)
    {
        int[] ans = new int[2];
        int[] tempArr = new int[A.length + 1];
        
        for(int i = 0; i < A.length; i++)
            tempArr[A[i]]++;
        
        // Taken care of index
        for(int i = 1; i < tempArr.length; i++)
        {
            if(tempArr[i] == 2)
                ans[0] = i;
            
            if(tempArr[i] == 0)
                ans[1] = i;
        }
        
        return ans;
    }
}



