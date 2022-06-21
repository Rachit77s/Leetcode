public class Solution {
    public void MoveZeroes(int[] A) {
        
        int left = 0;
        int right = 0;
        
        while(right < A.Length)
        {
            if(A[right] != 0)
            {
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;
                left++;
            }
            
            right++;
        }
    }
}