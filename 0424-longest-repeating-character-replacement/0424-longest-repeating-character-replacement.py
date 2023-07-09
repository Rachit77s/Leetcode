class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map = {}
        n = len(s)
        right = 0
        left = 0
        maxCharCount = 0
        ans = 0
        
        while right < n:
            ch = s[right]
            map[ch] = map.get(ch, 0) + 1
            maxCharCount = max(maxCharCount, map[ch])
            
            diffChar = (right - left + 1) - maxCharCount
            
            if(diffChar > k):
                innerCh = s[left]
                map[innerCh] = map.get(innerCh, 0) - 1
                
                left += 1
            
            
            ans = max(ans, right - left + 1)
            right += 1
            
        return ans
