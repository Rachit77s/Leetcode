class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        sub = []
        for val in nums:
            pos , sub_len = 0, len(sub)
            while(pos <= sub_len):    # update the element to the correct position of the sub.
                if pos == sub_len:
                    sub.append(val)
                    break
                elif val <= sub[pos]:
                    sub[pos] = val
                    break
                else:
                    pos += 1
        
        return len(sub)