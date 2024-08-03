class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ans = []
        
        windowSize = len(p)
        queue = collections.deque()
        mapOfP = Counter(p)
        mapOfS = Counter()
        
        for i in range(len(s)):
            queue.append(i)
            mapOfS[s[i]] += 1
            
            while len(queue) > windowSize:
                tchar = queue.popleft()
                mapOfS[s[tchar]] -= 1
                
            if len(queue) == windowSize and mapOfP == mapOfS:
                # dp[0]
                ans.append(queue[0])
                
        return ans            