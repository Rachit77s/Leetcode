class Solution {
    public int countDigitOne(int n) {
        
        return M1(n);
    }
    
    /*
        7162: 7000 + 100 + 60 + 2
        
        7000 - 7162: f(162)     Remainder
        6000 - 6999: f(999)     Quotient
        5000 - 5999: f(999)     Quotient
        4000 - 4999: f(999)     Quotient
        3000 - 3999: f(999)     Quotient
        2000 - 2999: f(999)     Quotient
        1000 - 1999: f(999) + 1000 * 1(No of 1's in 1000 to 1999)
        0 - 999:     f(999)     Quotient
        
    */
    
    // Babbar: Code Help
    public int M1(int n) 
    {
        if(n <= 0)
            return 0;
        
        if(n < 10)
            return 1;
        
        String str = String.valueOf(n);
        int length = str.length();
        double baseInDouble = Math.pow(10, length - 1);
        int base = (int)baseInDouble;
        int firstDigit = n / base;
        int remainder = n % base;
        
        int oneInBase = 0;
        
        if(firstDigit == 1)
            oneInBase = n - base + 1;
        else
            oneInBase = base;
        
        return M1(remainder) + oneInBase + firstDigit * M1(base - 1);
    }
    
    public int M2(int n) 
    {
        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit >  1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;

    }
}