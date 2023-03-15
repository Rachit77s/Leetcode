class Solution {
    public String minWindow(String s, String t) {
        
        return minWindowHelper(s, t);
    }
    
    // Pepcoding: https://www.youtube.com/watch?v=e1HlptlipB0
    public String minWindowHelper(String s, String t) 
    {
        
        String ans = "";
        int n = s.length();
        int sizePattern = t.length();
 
        if (s.length() < t.length()) 
        {
            // System.out.println("No such window exists");
            return "";
        }
 
        // HashMap<Character, Integer> patternFreqMap = new HashMap<Character, Integer>();
        int[] patternFreq = new int[256];
        int[] strFreq = new int[256];
        
        for(int i = 0; i < sizePattern; i++)
        {
            patternFreq[t.charAt(i)]++;
        }
        
        int left = 0;
        int startIdx = -1;
        int minWindowSize = Integer.MAX_VALUE;
        
        int matchCount = 0;
        
        for(int right = 0; right < n; right++)
        {
            char ch = s.charAt(right);
            strFreq[ch]++;
            
            // After acquiring element if its freq is less than or 
            // equal to req freq,then we can increase our matchCnt.
            // If after acquiring freq is greater it means 
            // we don't have any use of this element.
            // If string's char matches with pattern's char 
            // then increment count.
            if(strFreq[ch] <= patternFreq[ch])
                matchCount++;
    
            if(matchCount == t.length())
            {
                // At this point matchCount == sizePattern i.e. 
                // we have got an answer.
                // Now we will release elements and try to get 
                // the best shortest answer.
                // Try to minimize the window
                while(strFreq[s.charAt(left)] > patternFreq[s.charAt(left)] || 
                     patternFreq[s.charAt(left)] == 0)
                {
                    if(strFreq[s.charAt(left)] > patternFreq[s.charAt(left)])
                        strFreq[s.charAt(left)]--;
                    
                    left++;
                }
                
                int minLength = right - left + 1;
                if(minWindowSize > minLength)
                {
                    minWindowSize = minLength;
                    startIdx = left;
                }
            }
        }
            
        if (startIdx == -1) 
            // System.out.println("No such window exists");
            return "";
 
        // Return substring starting from start_index
        // and length minWindowSize
        return s.substring(startIdx,  startIdx + minWindowSize);
    }
}