class Solution(object):
    def isMonotonic(self, A):
        """
        :type nums: List[int]
        :rtype: bool
        """
        return not {cmp(i, j) for i, j in zip(A, A[1:])} >= {1, -1}