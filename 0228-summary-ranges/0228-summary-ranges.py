class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        
        ranges = collections.defaultdict(list)
        for i, n in enumerate(nums):
            ranges[n-i][1:] = n,
        return ['->'.join(map(str, r)) for r in sorted(ranges.values())]