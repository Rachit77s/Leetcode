class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        seen = set()
        
        for ch in sentence:
            seen.add(ch)
            
        if len(seen) == 26:
            return True
        
        return False