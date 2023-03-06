class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        return ApproachI(arr, k);
    }
    
    public int ApproachI(int[] A, int k)
    {
        
        HashSet<Integer> set = new HashSet();
        
        for(int i = 0; i < A.length; i++)
            set.add(A[i]);
        
        int cnt = 0;
        int i = 1;
        while(i < Integer.MAX_VALUE)
        {
            if(!set.contains(i))
                cnt++;
            
            if(cnt == k)
                return i;
            
            i++;
        }
        
        return i;
    }
}