class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        map = {}
        
        for index,num in enumerate(nums):
            if num in map:
                oldIdx = map[num]
                
                if abs(index - oldIdx) <= k:
                    return True
                
                map[num] = index
            else:
                map[num] = index
        
        return False