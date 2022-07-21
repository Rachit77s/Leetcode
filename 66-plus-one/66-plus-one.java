class Solution {
    public int[] plusOne(int[] digits) {
        
      return Method2(digits);
    }
    
    public int[] Method1(int[] digits)
    {
        int n = digits.length;
        
        for(int i = n - 1; i >= 0; i--)
        {
            // If the digit is not 9, simply increment and return
            if(digits[i] < 9)
            {
                digits[i] += 1;
                return digits;
            }
            
            // If we are here, it means digit is 9
            digits[i] = 0;
        }
        
        // By default all the values get initialised by 0.
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;  
    }
    
    public int[] Method2(int[] A)
    {
        int n = A.length;
        
        for(int i = n - 1; i >= 0; --i)
        {
            if(A[i] == 9)
            {
                A[i] = 0;
            }
            else
            {
                A[i]++;
                // Return from here itself.
                return A;
            }
        }
        
        // We are here it means digit is 0
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}