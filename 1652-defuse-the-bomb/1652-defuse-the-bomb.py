class Solution:
    def decrypt(self, A: List[int], k: int) -> List[int]:
        
        """
            A: 2 4 9 3
            Rev A: 3 9 4 2
            A+A:  3 9 4 2  3 9 4 2
                  13 6 5 12
            Rev of O/P: 12 5 6 13
         
        """
        
        
        if k == 0:
            return [0 for _ in A]
        
        if k > 0:
            ans = []
            n = len(A)
            A = A + A

            for i in range(n):
                total = 0
                
                for j in range(1, k+1):
                    total += A[(i+j)] 
                    
                ans.append(total)
                
            return ans

        if k < 0:
            k = abs(k)
            ans = []
            n = len(A)
            A = list(reversed(A))
            A = A + A
            #print(A)
                
            for i in range(n):
                total = 0

                for j in range(1, k+1):
                    total += A[(i+j)] 

                ans.append(total)

            return list(reversed(ans))