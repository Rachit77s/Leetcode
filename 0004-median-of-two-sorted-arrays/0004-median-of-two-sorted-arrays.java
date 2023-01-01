class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        return Median(nums1, nums2, m, n);
    }
    
    // Striver: https://www.youtube.com/watch?v=NTop3VTjmxk
    // https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
    public double Median(int arr1[], int arr2[], int m, int n)
    {
        // Ensure that binary search happens on minimum size array 
        if(m > n)
            return Median(arr2, arr1, n, m);
        
        int low = 0;
        int high = m; // Taking length 
        int medianPos = (m+n+1)/2;
        
        while(low <= high)
        {
            int cut1 = (low + high) / 2;
            int cut2 = medianPos - cut1;
            
            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1-1];
            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2-1];
            int R1 = (cut1 == m) ? Integer.MAX_VALUE : arr1[cut1];
            int R2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];
            
            // Partition is correct, find the median
            if(L1 <= R2 && L2 <= R1)
            {
                if((m + n) % 2 != 0)
                    return Math.max(L1, L2); // Odd Length
                else 
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
            }
            else if(L1>R2) 
                high = cut1-1;
            else 
                low = cut1+1;
        }
        
        return 0.0;
    }
}