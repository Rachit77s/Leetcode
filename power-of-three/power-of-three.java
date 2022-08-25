class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n <= 0)
            return false;
        
        while(n > 1) 
        {
            if(n % 3 != 0) 
                return false;
            
            n /= 3;
        }
        
        return n <= 0 ? false : true;
    }
}

// 3 9 27 81 243 729 2187 6561
// 6 12