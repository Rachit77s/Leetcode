class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        m, n = len(mat), len(mat[0])
        result = {}
        for j in range(n):
            for i in range(m):
                if mat[i][j] or i in result: continue
                result[i] = True
                k -= 1
                if not k: return result.keys()
        for i in range(m):
            if i not in result:
                result[i] = True
                k -= 1
                if not k: return result.keys()