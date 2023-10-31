class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        last = pref[0]
        res = [last] ### the first element in the result is the same as pref
        for n in pref[1:]:
            cur = n^last ### compute the current element in result
            res.append(cur) 
            last ^= cur ### update the XOR of all elements in result so far
        return res