class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        r, c = len(grid), len(grid[0])
        
        # This line of code is initializing a 2-dimensional list called visited using a list comprehension. 
        visited = [[False for _ in range(c)] for _ in range(r)]
        
        def dfs(i, j):
            if i < 0 or i >= r or j < 0 or j >= c or grid[i][j] == '0' or visited[i][j]:
                return
            
            # it is safe to make a move
            visited[i][j] = True
            
            dfs(i-1, j)
            dfs(i, j+1)
            dfs(i+1, j)
            dfs(i, j-1)
            
            
            
        count = 0
        
        for i in range(r):
            for j in range(c):
                if not visited[i][j] and grid[i][j] == '1':
                    dfs(i, j)
                    count += 1
                    
        return count