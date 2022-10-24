class Solution {
    public int characterReplacement(String s, int k) {
        
        return Helper(s, k);
        // return HelperWithHashMap(s, k);
    }
    
    // https://leetcode.com/problems/longest-repeating-character-replacement/discuss/358879/Java-Solution-Explained-and-Easy-to-Understand-for-Interviews
    public int Helper(String s, int k) 
    {
        int ans = 0;
        int[] hash = new int[26];
        int mostFreqCharCount = 0;
        
        int left = 0;
        int right = 0;
        
        while(right < s.length())
        {
            hash[s.charAt(right) - 'A']++;
            
            mostFreqCharCount = Math.max(mostFreqCharCount, hash[s.charAt(right) - 'A']);
  
            int windowLength = right - left + 1;
            
            // Tricky part
            int numOfOtherCharacters = windowLength - mostFreqCharCount;
            
            // We can slide the valid window till below condition satisfies
            // WindowLength - mostFreqCharCount <= K
            // But if exceeds, then we need to remove the left char and increment left          
            if(numOfOtherCharacters > k)
            {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Length would have been updated
            windowLength = right - left + 1;
            
            ans = Math.max(ans, windowLength);
            right++;
        }
        
        return ans;
    }
    
    public int HelperWithHashMap(String s, int k) 
    {
        Map<Character, Integer> map = new HashMap<>(); //char -> index
        int ans = 0;
        int mostFreqCharCount = 0;
        int left = 0, right = 0;
        int n = s.length();
        
        while(right < n)
        {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            mostFreqCharCount = Math.max(mostFreqCharCount, map.get(ch));
            
            int numOfOtherCharacters = (right - left + 1) - mostFreqCharCount;
            
            if(numOfOtherCharacters > k)
            {
                char leftMostChar = s.charAt(left);
                left++;
                map.put(leftMostChar, map.get(leftMostChar) - 1);
            }
            
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        
        return ans;
    }
}

// ABAB  A:2 B:2
// AABABBA  A:3 B:3
// "XYXXXRXRXRXORRIIR"
// ABCDAAOA    4