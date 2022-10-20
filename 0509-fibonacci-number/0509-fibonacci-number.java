class Solution {
    public int fib(int n) {
        
        return Iterative(n);
        // return Recursion(n);
    }
    
    public int Iterative(int n)
    {
        int prev = 0;
        int curr = 1;
        int next = 0;
        
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        
        for(int i = 2; i <= n; i++)
        {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    public int Recursion(int N)
    {
        if(N == 0)
            return 0;
        else if(N == 1)
            return 1;
        
        return Recursion(N-1) + Recursion(N-2);
            
    }
}