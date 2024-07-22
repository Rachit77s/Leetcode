import collections

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        map = Counter() #collections.defaultdict(int)
        queue = collections.deque()
        mlength = 0
        
        # If check is True, then remove the char from queue
        def check(map):
            for freq in map.values():
                if freq > 1:
                    return True
                
            return False
        
        
        for char in s:
            queue.append(char)
            map[char] += 1
            
            while check(map):
                removedChar = queue.popleft()
                map[removedChar] -= 1
                
            mlength = max(mlength, len(queue))

        return mlength
            