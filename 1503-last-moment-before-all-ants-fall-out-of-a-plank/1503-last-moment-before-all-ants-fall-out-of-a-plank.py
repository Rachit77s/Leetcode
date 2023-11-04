class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        maxLeft  = max(left)  if len(left) > 0 else 0
        minRight = min(right) if (len(right)) > 0 else n
        return max(maxLeft, n - minRight)