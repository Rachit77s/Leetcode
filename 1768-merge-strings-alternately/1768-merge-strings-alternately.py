class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n = len(word1)
        m = len(word2)
        
        sb = []
        i = 0;
        while i < n or i < m:
            if i < n:
                sb.append(word1[i])
                
            if i < m:
                sb.append(word2[i])    
                
            i += 1
            
        return ''.join(sb)