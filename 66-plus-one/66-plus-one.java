class Solution {
    public int[] plusOne(int[] digits) {
        
      return Method3(digits);
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
                
                // After incrementing, directly return.
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
    
    public int[] Method3(int[] A)
    {
        int index = A.length - 1;
        // Start carry with 1 as we need to append 1 to every number.
        int carry = 1;
        
        while(index >= 0 && carry > 0)
        {
            A[index] = (A[index] + carry) % 10;
            
            // 10 % 10 --> 0
            if(A[index] == 0)
                carry = 1;
            else
                carry = 0;
            
            index--;
        }
        
        if(carry > 0) 
        {
            A = new int[A.length+1];
            A[0] = 1;
        }    

        return A;
    }
}