class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        
        def hashMap(nums):
            dict = {}
            ans = 0
            
            for item in nums:
                dict[item] = dict.get(item, 0) + 1
                
            print(dict)
            for key, value in dict.items():
                if value == 1:
                    ans = key
                    break
            
            return ans
        
        # return hashMap(nums)
    
        a = b = 0
        for n in nums:
            b = (b^n)&~a
            a = (a^n)&~b
        return b