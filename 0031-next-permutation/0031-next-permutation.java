class Solution {
    public void nextPermutation(int[] A) {
        
        // https://www.youtube.com/watch?v=JDOXKqF60RQ&ab_channel=takeUforward
        StriverApproach(A);
        
        // https://www.youtube.com/watch?v=6qXO72FkqwM&ab_channel=Techdose
    }
    
    public void StriverApproach(int[] A)
    {
        // I/P: 2 1 5 4 3 0 0
        // O/P: 2 3 0 0 1 4 5
        
        /*
            I/P: 1241
            O/P: 1412

            I/P: 1243
            O/P: 1324

            I/P: 12323
            O/P: 12332

            I/P: 2342
            O/P: 2423
            Swap & sort

            Move the peak with less weightage

        */
        
        // Step 1: Get some other element that is just greater than me
        // i.e. Find the break point, Move the peak with less weightage
        // Find the just greater number from the last
        int n = A.length;
        
        if(n < 2)
            return;
        
        int index = -1;
        for(int i = n-2; i >= 0; i--)
        {
            // curr ele is lesser than its next element
            if(A[i] < A[i+1])
            {
                index = i;
                break;
            }
        }
        
        // For already sorted array in desc order
        if(index == -1)
        {
            Arrays.sort(A);
            return;
        }
        
        // I/P: 2 1 5 4 3 0 0
        // O/P: 2 3 0 0 1 4 5
        
        // Step 2: Find the element that is just greater than the break point and swap
//         int justGreaterValueIndex = index+1;
         
//         for(int i = index + 1; i < n; i++)
//         {
//             if(A[index] < A[i] && A[i] <= A[justGreaterValueIndex])
//             {
//                 justGreaterValueIndex = i;
//             }
//         }
        
        // Aliter of Step 2: Start from the last
        for(int i = n - 1; i > index; i--)
        {
            if(A[i] > A[index])
            {
                Swap(A, i, index);
                break;
            }
        }
            
        // Step 3: Swap remaining elements
//         int tmp = A[index];
//         A[index] = A[justGreaterValueIndex];
//         A[justGreaterValueIndex] = tmp;
        
        SwapRemainingArray(A, index+1, n-1);
        
        return;
    }
    
    public void Swap(int[] A, int startIndex, int endIndex)
    {
        int tmp = A[startIndex];
        A[startIndex] = A[endIndex];
        A[endIndex] = tmp;
    }
    
    public void SwapRemainingArray(int[] A, int startIndex, int endIndex)
    {
        while(startIndex < endIndex)
        {
            int tmp = A[startIndex];
            A[startIndex] = A[endIndex];
            A[endIndex] = tmp;
            
            startIndex++;
            endIndex--;
        }
    }
    
}