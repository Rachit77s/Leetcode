class Solution {
    public int minFlipsMonoIncr(String s) {
        
        return Helper(s);
    }
    
    // Very hard question
    public int Helper(String s)
    {
        int countOne = 0;
        int countFlip = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '1')
                countOne++;
            else
                countFlip++;
            
            countFlip = Math.min(countFlip, countOne);
        }
        
        return countFlip;
    }
}

// 00110 --> 00111
// 010110 -->01111