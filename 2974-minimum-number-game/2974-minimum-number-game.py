import heapq

class Solution:
    def numberGame(self, nums: List[int]) -> List[int]:
        arr = []
        heapq.heapify(nums)  # Convert nums into a heap in-place

        while nums:
            alice = heapq.heappop(nums)
            bob = heapq.heappop(nums)
            arr.append(bob)
            arr.append(alice)

        return arr