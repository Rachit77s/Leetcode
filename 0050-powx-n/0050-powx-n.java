class Solution {
    public double myPow(double x, int n) {
        
        // Divide and conquer
        
        return BinaryExponentiation(x, n);
    }
    
    public double BinaryExponentiation(double x , int n)
    {
        // Base being squared, exponent getting halved.
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        
        while (m != 0) 
        {
            if (m % 2 != 0) // check if m is odd number
                ans *= x; // 2¹ * 2² * 2⁴, etc
            
            x *= x;
            m /= 2; // binary search
        }
        return n >= 0 ? ans : 1 / ans;
    }
    
    public double RecursionHelper(double x, int n) 
    {
        // Divide and conquer
        if(x == 0)
            return 0;
        
        if(n == 0)
            return 1;
        
        if(x == 1)
            return 1;
        
        double ans = RecursionHelper(x, Math.abs(n / 2));
        
        ans = ans * ans;
        
        if(n % 2 == 1)
            ans = ans * x;
        
        if(ans < 0)
            return 1/ans;
        
        return ans;
    }
}