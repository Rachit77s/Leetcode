class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        return BFS(grid);
    }
    
    int[] DIRx = new int[]{-1, -1, -1, 0, 1, 1, 1,  0};
    int[] DIRy = new int[]{-1,  0,  1, 1, 1, 0, -1, -1};
        
    public int BFS(int[][] A)
    {
        int R = A.length;
        int C = A[0].length;

        if(A[0][0] == 1 || A[R-1][C-1] == 1) 
            return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0}); // dist, r, c
        
        boolean[][] visited = new boolean[R][C];
        visited[0][0] = true;
        
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int dist = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            // Got the destination
            if (r == R - 1 && c == C - 1) 
                return dist;
            
            for (int[] neighbor : GetAllValidNeighbours(A, r, c)) 
            {
                int nr = neighbor[0];
                int nc = neighbor[1];
                
                if (visited[nr][nc] == false) 
                {
                    visited[nr][nc] = true;
                    queue.add(new int[]{dist + 1, nr, nc});
                }
            }
        }
        
        return -1;
    }
    
    // Gives all the VALID neighbours of given row and column
    public List<int[]> GetAllValidNeighbours(int[][] A, int r, int c)
    {
        int R = A.length;
        int C = A[0].length;
        
        List<int[]> validNeighbors = new ArrayList<>();
        
        for(int i = 0; i < 8; i++)
        {
            int nr = r + DIRx[i];
            int nc = c + DIRy[i];
            
            // IsSafeFn
            if(nr >= 0 && nr < R && nc >= 0 && nc < C
              && A[nr][nc] == 0)
            {
                validNeighbors.add(new int[]{nr, nc});
            }
        }
        
        return validNeighbors;
    }
}