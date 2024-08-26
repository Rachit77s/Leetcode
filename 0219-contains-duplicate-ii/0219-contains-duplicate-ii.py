class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        queue = deque()
        seen = set()
        
        for index,val in enumerate(nums):
            if val in seen:
                return True
            
            seen.add(val)
            
            if len(seen) > k:
                seen.remove(nums[index-k])
 

        return False