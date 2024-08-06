class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        map = Counter()
        queue = collections.deque()
        ans = 0
        
        def check(counter):
            for freq in counter.values():
                if freq > 1:
                    return False
            
            return True
        
        for char in s:
            queue.append(char)
            map[char] += 1
            
            while len(queue) > 3:
                tchar = queue.popleft()
                map[tchar] -= 1
                
            if len(queue) == 3 and check(map):
                ans += 1
                
        return ans
    
    #x y z zaz
        