class Solution {
    public int minFlipsMonoIncr(String s) {
        
        return Helper(s);
    }
    
    // Very hard question
    public int Helper(String s)
    {
        int countOne = 0;
        int countFlip = 0;
        
        /*
            When We are traversing in the string S there will be two possibility

        Char=='1'
        It will not impact our minimum flips just keep the record of count of 1
        Char=='0'
        Here will be 2 cases
            Keep is as 0 and flip all the 1 so far ,for that we need to know about the count one so far
            Or else, Flip 0 to 1 and update our count_flip
        Take the minmum of count_flip and count_one and update the count_flip because we want minimum(dry run for 1110000)
        
        // if c is 1, then it will not inpact the minFlips
            // if c is 0, then 2 options we can do to make it mono incr
            // 1. keep it as 0, and flip all the preceeding 1 to 0, need to know the count of ones so far
            // 2. flip it to 1, will not need to do anything    
        */
        
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