class Solution:
    def decrypt(self, A: List[int], k: int) -> List[int]:
        
        # 5 7 1 4 - 5 7 1 4
        
        if k == 0:
            return [0 for _ in A]
        
        if k > 0:
            ans = []
            n = len(A)
            
            for i in range(n):
                total = 0
                
                for j in range(1, k+1):
                    total += A[(i+j) % n] 
                    
                ans.append(total)
                
            return ans
        
        if k < 0:
            k = abs(k)
            ans = []
            n = len(A)
            
            for i in range(n):
                total = 0
                
                for j in range(1, k+1):
                    total += A[(i-j) % n] 
                    
                ans.append(total)
                
            return ans
                    
            