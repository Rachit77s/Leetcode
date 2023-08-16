class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if len(nums) <= k:
            return [max(nums)]
        
        n = len(nums)
        res = []        
        
        pq = [(-num, i) for i, num in enumerate(nums[:k])]
        heapify(pq)        
        res.append(-pq[0][0])
        
        s = 0        
        for i in range(k, n):
            s += 1            
            while pq and pq[0][1] < s:
                heappop(pq)   
            
            heappush(pq, (-nums[i], i))            
            res.append(-pq[0][0])
        
        return res