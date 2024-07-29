class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        map = Counter()
        n = len(s)
        
        for r in range(9,n):
            # create new substring from 0 to 10, last idx is excluding
            subStr = s[r-9: r+1]
            
            map[subStr] += 1
            
        # return all the strings which satisfy the condition
        return [sub for sub in map if map[sub] > 1]