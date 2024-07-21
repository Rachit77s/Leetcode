class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLength = 0;
        int[] charFreq = new int[256];
        
        int left = 0, right = 0;
        while(right < s.length()) {
            charFreq[s.charAt(right)]++;
            
            while(left <= right && charFreq[s.charAt(right)] > 1) {
                charFreq[s.charAt(left)]--;
                left++;
            }
             
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
}