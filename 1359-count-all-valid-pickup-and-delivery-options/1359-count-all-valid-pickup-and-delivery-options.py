from functools import reduce
class Solution:
    def countOrders(self, n: int) -> int:
		# remember to use generator instead of tuple for O(1) space complexity
        return reduce(lambda x, y: x * y % (10**9+7), (v for x in range(1,n+1) for v in (x, 2*x-1)), 1)