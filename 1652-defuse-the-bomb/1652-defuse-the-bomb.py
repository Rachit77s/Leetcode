class Solution:
    def decrypt(self, A: List[int], k: int) -> List[int]:
        
        """
            A: 2 4 9 3
            Rev A: 3 9 4 2
            A+A:  3 9 4 2  3 9 4 2
                  13 6 5 12
            Rev of O/P: 12 5 6 13
            
            
            
          5  7  1  4    5  7  1  4
          12 10 16 13   12 10 16 13
         
        """
        
        
        n = len(A)
        K = abs(k)
        
        if k < 0:
            A.reverse()
            
        A = A + A
        P = list(accumulate(A))
        
        ans = []
        
        for i in range(n):
            ans.append(P[i+K] - P[i])
            
        if k < 0:
            ans.reverse()
            
        return ans