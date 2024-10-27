class Solution:
    def haveConflict(self, e1: List[str], e2: List[str]) -> bool:
        return e1[0] <= e2[1] and e2[0] <= e1[1]