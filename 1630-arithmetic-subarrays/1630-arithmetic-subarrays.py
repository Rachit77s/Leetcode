class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        def isArith(n):
            st = set(n)
            if len(n) != len(st): return len(st) == 1 # take care of duplicates
            mx, mn, = max(n), min(n)
            if (mx - mn)%(len(n)-1) != 0: return False
            step = (mx - mn)//(len(n)-1)
            for i in range(mn, mx, step):
                if i not in st:
                    return False
            return True   
        
        return [isArith(nums[start:stop+1]) for start, stop in zip(l,r)]