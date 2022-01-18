public class Solution {
    public int FirstMissingPositive(int[] nums) {
        
        return LeetcodeApproach(nums);
        //return FirstMissingPositiveTricky(nums);
        //return Hashing(nums);
    }
    
    public int LeetcodeApproach(int[] A)
    {
        // https://leetcode.com/problems/first-missing-positive/discuss/319270/Explanation-of-crucial-observation-needed-to-deduce-algorithm
        // https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
        
        int n = A.Length;
        
        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < A.Length; i++)
        {
            if(A[i] <= 0 || A[i] > n)
            {
                A[i] = n+1;
            }
        }
        
        // note: all number in the array are now positive, and on the range 1..n+1
        
        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < A.Length; i++)
        {
            // Get abs value
            int num = Math.Abs(A[i]);
            
            if(num > n)
            {
                continue;
            }
            
            // since A[4](5th idx) = 5, O based indexing
            // -1 for zero index based array (so the number 1 will be at pos 0)
            num--;
            
            // Mark the number as appeared by making it negative
            if(A[num] > 0)
            {
                A[num] = -1 * A[num];
            }
        }
        
        
        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) 
        {
            if(A[i] >= 0)
            {
                return i+1;
            }
        }
        
        // 4. no positive numbers were found, which means the array contains all numbers 1..n, hence, return n + 1
        return n+1;
    }
    
    public int FirstMissingPositiveTricky(int[] A)
    {
        
        // https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c%2B%2B-solution-O(1)-space-and-O(n)-time
        // https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/

        // We will bring all the numbers at their correct place/indexe.
        // When we find 5, then swap it with A[4].
        // At last, the first place where its number is not right, return the place + 1.

        // Solution is tricky, dry run, you will understand.

        /*
            Algo:
            1. Traverse the array, Ignore the elements which are greater than n and less than 1.
            2. While traversing check a[i]!=a[a[i]-1] if this condition hold true or not .
            3. If the above condition is true then swap a[i], a[a[i] – 1]  && swap until a[i] != a[a[i] – 1]  condition will fail .
            4. Traverse the array and check whether a[i] != i + 1 then return i + 1.
            5. If all are equal to its index then return n+1.
        */

        for (int i = 0; i < A.Length; i++)
        {
            // While Loop to check boundary condition and for swapping
            while(A[i] > 0 && A[i] <= A.Length && A[i] != A[A[i] - 1])
            {
                // Swap
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }

        // Find the missing element
        for (int i = 0; i < A.Length; i++)
        {
            if (A[i] != i + 1)
                return i + 1;
        }

        // If there is no missing element.
        return A.Length + 1;
    }

    
    public int Hashing(int[] nums)
    {
        HashSet<int> set = new HashSet<int>();
        
        for (int i = 0; i < nums.Length; i++)
        {            
            // Assuming no duplicates
            set.Add(nums[i]);
            
        }
        
        int num = 1;
        for (int i = 0; i < set.Count; i++)
        {
            if(!set.Contains(num))
            {
                return num;
            }
            
            num++;
        }
        
        return num;
    }
}