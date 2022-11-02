class Solution {
    public int findTheWinner(int n, int k) {
        
        return RecursionHelper(n, k);
    }
    
    // Babbar: Code Help https://www.thecodehelp.in/s/courses/62d687250cf20fa2aeac4205/take
    public int RecursionHelper(int n, int k) 
    {
        // +1 because after mod we will get 0,1,2 etc
        // Hence +1 to start it from 1
        int ans = Recursion(n, k) + 1; 
        return ans;
    }
    
    public int Recursion(int n, int k) 
    {
        if(n == 1)
            return 0;
        
        // Dry run and get this from observation
        return (Recursion(n-1, k) + k) % n;
    }
}