class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        s_counter = Counter()
        K = minSize
    
        for i in range(len(s)):
            sub = s[i:i+K]
            if len(sub) != K:
                continue
            
            if len(set(list(sub))) > maxLetters:
                continue
            
            s_counter[sub] += 1
        
        return max(s_counter.values(), default=0)