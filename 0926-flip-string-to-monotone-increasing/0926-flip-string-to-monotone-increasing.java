class Solution {
    public int minFlipsMonoIncr(String s) {
        
        return OptimizedApproach(s);
        // return BruteForce(s);
    }
    
    // Subham: https://www.scaler.com/help_requests/662642/?ref=join-call-now
    public int BruteForce(String s)
    {
        // To make string monotonic increasing, at every index
        // We need to make all the, 1's at the left of the index to 0
        // And, all the 0's to the right of the index's to 1
        // The current char sign for whom we are calculating doesn't matter 
        // Because consider,  11011   so for 0 we will make left to it 0
        // And right to it as 1, and 0 wouldn't matter at all.
        
        int n = s.length();
        // int leftOnes = 0;
        // int rightZeroes = 0;
        int ans = Integer.MAX_VALUE;

        for(int index = 0; index < n; index++)
        {
            int leftOnes = 0;
            int rightZeroes = 0;
            
            for(int leftIdx = index - 1; leftIdx >= 0; leftIdx--)
            {
                if(s.charAt(leftIdx) == '1')
                    leftOnes++;
            }
            
            for(int rightIdx = index + 1; rightIdx < n; rightIdx++)
            {
                if(s.charAt(rightIdx) == '0')
                    rightZeroes++;
            }
            
            // We need to flip all the 1's on the left &
            // all the 0;s on the right, which will give us monotonic
            // The no of 1's on the left + no of 0's on right
            // together gives us the flips required
            ans = Math.min(ans, leftOnes + rightZeroes);
        }
        
        return ans;
    }
    
    
    public int OptimizedApproach(String s)
    {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        
        // Initialize two lists to store the number of 
        // 1s on the left and the number of 0s on the right
        // Calculate prefix 1's
        int[] prefixOnes = new int[n];
        if(s.charAt(0) == '1')
            prefixOnes[0] = 1;
        else
            prefixOnes[0] = 0;
        
        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i) == '1')
                prefixOnes[i] = prefixOnes[i - 1] + 1;
            else
                prefixOnes[i] = prefixOnes[i - 1] + 0;
        }
        
        // Calculate suffix 0's
        int[] suffixZeroes = new int[n];
        if(s.charAt(n-1) == '0')
            suffixZeroes[n-1] = 1;
        else
            suffixZeroes[n-1] = 0;
        
        for(int i = n - 2; i >= 0; i--)
        {
            if(s.charAt(i) == '0')
                suffixZeroes[i] = suffixZeroes[i + 1] + 1;
            else
                suffixZeroes[i] = suffixZeroes[i + 1] + 0;
        }
        
        for(int index = 0; index < n; index++)
        {
            // We need prefix sum till the curr index-1
            int leftOnes = (index == 0 ? 0 : prefixOnes[index - 1]);
            // We need suffix sum from the curr index+1
            int rightZeroes = (index == n-1 ? 0 : suffixZeroes[index + 1]);
            
            ans = Math.min(ans, leftOnes + rightZeroes);
        }
        
        return ans;
    }
}