class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n<=0:
            return False
        x=math.log(n,4)
        return x==int(x)