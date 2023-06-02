class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        n = len(bombs)
        g = [[] for i in range(n)]
        visited = [None] * n
        
        for i, (x0, y0, r0) in enumerate(bombs):
            for j, (x1, y1, _) in enumerate(bombs):
                if i != j and (x1-x0)**2 + (y1-y0)**2 <= r0**2:
                    g[i] += [j]

        def dft(node):
            nonlocal visited, v
            for child in g[node]:
                if ~(v >> child) & 1:
                    if visited[child]:
                        v |= visited[child]
                    else:
                        v |= (1 << child)
                        dft(child)
        
        C = 0
        for i in range(n):
            v = 1 << i
            dft(i)
            C = max(C, bin(v).count('1'))
            visited[i] = v
        return C