class Solution {
    
    int[] DIRx = new int[]{-1, 0, 1, 0};
    int[] DIRy = new int[]{ 0, 1, 0, -1};
    
    public void solve(char[][] board) {
        
        DFSHelper(board);
    }
    
    public void DFSHelper(char[][] A)
    {
        int R = A.length;
        int C = A[0].length;
        
        // First row and last row
        for(int j = 0; j < C; j++)
        {
            if(A[0][j] == 'O')
                DFS(A, 0, j);

            if(A[R-1][j] == 'O')
                DFS(A, R-1, j);
        }

        // First col and last col
        for(int i = 0; i < R; i++)
        {
            if(A[i][0] == 'O')
                DFS(A, i, 0);

            if(A[i][C-1] == 'O')
                DFS(A, i, C-1);
        }


        for (int i = 0; i < R; i++) 
        {
            for (int j = 0; j < C; j++) 
            {
                if(A[i][j] == 'O')
                    A[i][j] = 'X';
            }
        }
        
        for (int i = 0; i < R; i++) 
        {
            for (int j = 0; j < C; j++) 
            {
                if(A[i][j] == 'S')
                    A[i][j] = 'O';
            }
        }
    }
    
    public void DFS(char[][] A, int r, int c)
    {
        A[r][c] = 'S';
        
        for(int[] neighbour : GetAllValidNeighbours(A, r, c))
        {
            int nr = neighbour[0];
            int nc = neighbour[1];
            
            if(A[nr][nc] == 'O')
                DFS(A, nr, nc);
        }
    }
    
    public List<int[]> GetAllValidNeighbours(char[][] A, int r, int c)
    {
        int R = A.length;
        int C = A[0].length;
        
        List<int[]> validNeighbors = new ArrayList<>();
        
        for(int i = 0; i < 4; i++)
        {
            int nr = r + DIRx[i];
            int nc = c + DIRy[i];
            
            // IsSafeFn
            if(nr >= 0 && nr < R && nc >= 0 && nc < C)
            {
                validNeighbors.add(new int[]{nr, nc});
            }
        }
        
        return validNeighbors;
    }
}