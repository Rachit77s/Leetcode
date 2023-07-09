class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map = {}
        mostFreqCharCount, l, ans = 0, 0, 0
        
        
        for r in range(len(s)):
            map[s[r]] = 1 + map.get(s[r], 0)
            
            mostFreqCharCount = max(mostFreqCharCount, map.get(s[r], 0))
            currLength = r - l + 1
            
            if currLength - max(map.values()) > k:
                # print(s[l])
                map[s[l]] = map.get(s[l], 0) - 1
                l += 1
                
            ans = max(ans, r - l + 1)
            
        return ans