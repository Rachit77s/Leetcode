class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        
        A = x
        reverse = 0
        # remainder = 0
        
        while A > 0: 
            remainder = A % 10  # 1
            reverse = reverse * 10 + remainder  #1
            A = A // 10
            # print()
            
        if reverse == x:
            return True
        
        return False
        