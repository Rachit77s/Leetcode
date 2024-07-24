class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        queue = collections.deque()
        vowels = "aeiou"
        
        currCount = 0
        maxCount = 0
        
        for char in s:
            currCount += char in vowels
            queue.append(char)
            
            if len(queue) > k:
                removedChar = queue.popleft()
                currCount -= removedChar in vowels
                
            maxCount = max(maxCount, currCount)
                
        return maxCount
        