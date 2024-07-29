class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        ans = float(-inf)
        sum = 0
        queue = collections.deque()
        
        for val in nums:
            sum += val
            queue.append(val)
            
            while queue and len(queue) > k:
                temp = queue.popleft()
                sum -= temp
            
            if len(queue) == k:
                avg = sum / k
                ans = max(ans, avg)
            
        return ans
        