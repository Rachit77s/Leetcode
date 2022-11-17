class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        return DPSoln(nums1, nums2);
        // return BruteForce2Helper(nums1, nums2);
        // return BruteForce1Helper(nums1, nums2);
    }
    
    /*
        Babbar Code Help Recursion series
        BruteForce Logic: Either we will swap the number or we won't swap.
        This is similar to Include/Exclude logic.
        
        Edge Case:
        A: [0,4,4,5,9]
        B: [0,1,6,8,10]
    */
    
    public int BruteForce1Helper(int[] A, int[] B) 
    {
        // isSwapped: false means previous indexes were not swapped
        int index = 1;
        boolean isSwapped = false;
        return BruteForce1Recursion(A, B, index, isSwapped);
    }
    
    public int BruteForce1Recursion(int[] A, int[] B, int index, boolean isSwapped) 
    {
        if(index == A.length)
            return 0;
        
        int swap = Integer.MAX_VALUE;
        int dontSwap = Integer.MAX_VALUE;
        
        int prevValueA = A[index - 1];
        int prevValueB = B[index - 1];
        
        if(isSwapped == true)
        {
            // int temp = prevValueA;
            // prevValueA = prevValueB;
            // prevValueB = temp;
            SwapValues(prevValueA, prevValueB);
        }
        
        
        // Don't swap
        if(A[index] > prevValueA && B[index] > prevValueB)
            dontSwap = BruteForce1Recursion(A, B, index + 1, false);
            
        // Swap
        if(A[index] > prevValueB && B[index] > prevValueA)
            swap = 1 + BruteForce1Recursion(A, B, index + 1, true);
        
        // Return the final ans out of the 2
        return Math.min(dontSwap, swap);
    }
    
    public int BruteForce2Helper(int[] A, int[] B) 
    {
        // Virtual Swap or No swapping method
        int index = 0;
        int prevValueA = -1; 
        int prevValueB = -1; 
        return BruteForce2Recursion(A, B, index, prevValueA, prevValueB);
    }
    
    public int BruteForce2Recursion(int[] A, int[] B, int index, int prevValueA, int prevValueB) 
    {
        if(index == A.length)
            return 0;
        
        int swap = Integer.MAX_VALUE;
        int dontSwap = Integer.MAX_VALUE;

        // Don't swap
        if(A[index] > prevValueA && B[index] > prevValueB)
            dontSwap = BruteForce2Recursion(A, B, index + 1, A[index], B[index]);
            
        // Swap: Change order of prevValueA and prevValueB
        if(A[index] > prevValueB && B[index] > prevValueA)
            swap = 1 + BruteForce2Recursion(A, B, index + 1, B[index], A[index]);
        
        // Return the final ans out of the 2
        return Math.min(dontSwap, swap);
    }
    
    public void SwapValues(int value1, int value2)
    {
        int temp = value1;
        value1 = value2;
        value2 = temp;
    }
    
    public int DPSoln(int[] A, int[] B) {
        int n = A.length;
        int not_swap[] = new int[n]; 
        //not_swap[i] -> min swaps to make {A[0]~A[i]} and {B[0]~B[i]} without swapping A[i] and B[i]
        int swap[] = new int[n];
        //swap[i] -> min swaps to make {A[0]~A[i]} and {B[0]~B[i]} with swapping A[i] and B[i]
        Arrays.fill(not_swap, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        not_swap[0] = 0;
        swap[0] = 1;
        
        for(int i = 1; i < n; i++) {
            if(A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1; //swap both A[i - 1], B[i - 1] & A[i], B[i]
                not_swap[i] = not_swap[i - 1]; //don't swap both A[i - 1], B[i - 1] & A[i], B[i]
            }
            if(A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(swap[i], not_swap[i - 1] + 1); //if we swap A[i],B[i], we don't need to swap A[i - 1],B[i - 1] 
                //not_swap[i - 1] + 1 because we didn't swap A[i - 1] & B[i - 1] and +1 for current swap 
                not_swap[i] = Math.min(not_swap[i], swap[i - 1]); //if we swap A[i - 1],B[i - 1], we don't need to swap A[i],B[i]
            }
        }
        
        return Math.min(swap[n - 1], not_swap[n - 1]);
    }
}