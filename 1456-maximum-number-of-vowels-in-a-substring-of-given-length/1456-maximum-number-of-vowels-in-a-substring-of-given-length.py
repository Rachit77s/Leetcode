class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowel = "aeiou"
        ans = 0
        queue = collections.deque()
        count = 0
        
        for char in s:
            if char in vowel:
                count += 1
                
            queue.append(char)
            
            if len(queue) > k:
                tchar = queue.popleft()
                if tchar in vowel:
                    count -= 1

            if len(queue) == k:
                ans = max(ans, count)
            
        return ans