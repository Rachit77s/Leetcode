class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ans = []
        
        windowSize = len(p)
        mapOfP = Counter(p)
        mapOfS = Counter()
        left = 0
        
        for right, char in enumerate(s):
            mapOfS[char] += 1
            
            while right - left + 1 > windowSize:
                tchar = s[left]
                mapOfS[tchar] -= 1
                left += 1
                
            if right - left + 1 == windowSize and mapOfP == mapOfS:
                ans.append(left)
                
        return ans            