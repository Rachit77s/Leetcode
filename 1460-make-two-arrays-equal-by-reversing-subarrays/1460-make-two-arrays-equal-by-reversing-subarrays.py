class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        # Frequency count for arr
        arrFreq = {}
        for num in arr:
            arrFreq[num] = arrFreq.get(num, 0) + 1

        for num in target:
            # If num does not appear in target, then arrays are not equal
            if num not in arrFreq:
                return False

            # Decrement the frequency count for num and
            # remove key if the count goes to 0
            arrFreq[num] -= 1
            if arrFreq[num] == 0:
                del arrFreq[num]
        return len(arrFreq) == 0