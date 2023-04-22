class Solution {
    public int findPeakElement(int[] nums) {
        
        return FindPeak(nums);
    }
    
    public int FindPeak(int[] A) 
    {
        /*
        https://www.scaler.com/meetings/i/get-amazon-ready-live-mock-coding-interview-2/archive
          1.
            A[0] > A[1] : A[0] is a peak element
            A[n-1] > A[n-2] : A[n-1] is a peak element
            
          2. 
            A[i-1] < A[i] > A[i+1] : A[i] is a peak element
            
          3.
            A[i-1] < A[i] < A[i+1] : A[i+1] can be a peak element
            However, A[i-1] will definitely not be a peak element
            
          4.
            A[i-1] > A[i] > A[i+1] : A[i-1] can be a peak element
            However, A[i+1] will definitely not be a peak element
          
          5. Moving on a greater side can generate a peak element
            A[i-1] > A[i] < A[i+1]:
            A[i-1] or A[i+1] can be a peak element. Explore
            
        */
        
        int n = A.length;
        
        if(n == 1)
            return 0;
        
        if(A[0] > A[1])
            return 0;
        
        if(A[n-1] > A[n-2])
            return n-1;
        
        int left = 1;
        int right = n-2;
        
        while(left <= right)
        {
            int mid = (left + right) / 2;
            
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;
            else if(A[mid - 1] > A[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
}