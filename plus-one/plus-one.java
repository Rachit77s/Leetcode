class Solution {
    public int[] plusOne(int[] digits) {
        
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
        
        
//         int n = digits.length;
//         for(int i=n-1; i>=0; i--) 
//         {          
//             if(digits[i] < 9) 
//             {
//                 digits[i]++;
//                 return digits;
//             }

//             digits[i] = 0;
//         }

//         int[] newNumber = new int [n+1];
//         newNumber[0] = 1;
        
        
        
        
        
    }
}