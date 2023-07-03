class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        mismatchCount = 0
        
        if len(s) != len(goal):
            return False
        
        # If set of s is less than its length, return true. Ex aa & aa
        if s == goal and len(set(s)) < len(s):
            return True
        
        diff = []
        
        for i in range(len(goal)):
            if s[i] != goal[i]:
                diff.append([s[i], goal[i]])
        
        if len(diff) == 2 and diff[0] == diff[-1][::-1]:
            return True
        
        return False
        
        