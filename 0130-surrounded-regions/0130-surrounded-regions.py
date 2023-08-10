class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        R = len(board)
        C = len(board[0])
        
        def neighbors(x,y):
            for r,c in ((x+1,y),(x-1,y),(x,y+1),(x,y-1)):
                if 0 <= r < R and 0 <= c < C:
                    yield r,c
        
        def dfs(r,c):
            board[r][c] = "S"
            
            for nr, nc in neighbors(r,c):
                if board[nr][nc] == "O":
                    dfs(nr,nc)
                    
        for r in range(R):
            if board[r][0] == "O":
                dfs(r,0)
            if board[r][C-1] == "O":
                dfs(r,C-1)
                
        for c in range(C):
            if board[0][c] == "O":
                dfs(0,c)
            if board[R-1][c] == "O":
                dfs(R-1,c)
                
        for r in range(R):
            for c in range(C):
                if board[r][c] == "O":
                    board[r][c] = "X"
                    
        for r in range(R):
            for c in range(C):
                if board[r][c] == "S":
                    board[r][c] = "O"