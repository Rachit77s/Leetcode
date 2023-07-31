class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        
        def BruteForce(s):
            n = len(s)
            ans = float('inf')
            
            for index in range(n):
                
                leftOnes = 0
                rightZeroes = 0
                
                for leftIdx in range(index - 1, -1, -1):
                    if s[leftIdx] == '1':
                        leftOnes += 1
                        
                for rightIdx in range(index + 1, n):
                    if s[rightIdx] == '0':
                        rightZeroes += 1
                        
                ans = min(ans, leftOnes + rightZeroes)
                
            return ans
        
        def Optimized(s):
            n = len(s)
            ans = float('inf')
            
            prefixOnes = [0] * len(s)
            if s[0] == '1':
                prefixOnes[0] = 1
            else:
                prefixOnes[0] = 0
                
            suffixZeroes = [0] * len(s)
            if s[n-1] == '0':
                suffixZeroes[n-1] = 1
            else:
                suffixZeroes[n-1] = 0
            
#             for index in range(n):
#                 # We need prefix sum till the curr index-1
#                 leftOnes = 0 if index == 0 else prefixOnes[index - 1]
#                 # We need suffix sum from the curr index+1
#                 rightZeroes = 0 if index == n-1 else suffixZeroes[index + 1]

#                 ans = min(ans, leftOnes + rightZeroes);
            
#             return ans
        
        
        n = len(s)
        cnt0 = s.count('0')
        cnt1 = 0
        res = n - cnt0
        for i in range(n):
            if s[i] == '0': 
                cnt0 -= 1
            elif s[i] == '1':
                res = min(res, cnt1+cnt0)
                cnt1 += 1
        return res
        #creturn Optimized(s)