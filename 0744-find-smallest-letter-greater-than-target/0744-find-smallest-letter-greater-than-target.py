class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        # if the number is out of bound
        if target >= letters[-1] or target < letters[0]:
            return letters[0]
        
        low = 0
        high = len(letters)-1
        while low <= high:
            mid = (high+low)//2
            
            if  target >= letters[mid]: # in binary search this would be only greater than
                low = mid+1
            
            if target < letters[mid]:
                high = mid-1
                
        return letters[low]