class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        return OptimizedApproach(arr, k);
    }
    
    public int OptimizedApproach(int[] arr, int k)
    {
        int n = arr.length;
        int start = 0, end = n-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] - (mid + 1) < k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start + k;
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