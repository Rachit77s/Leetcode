class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        return BFS(grid);
    }
    
    class Node {
        int row;
        int col;
        int dist;
        Node(int x, int y, int dist) {
            this.row = x;
            this.col = y;
            this.dist = dist;
        }
    }
    public int BFS(int[][] A)
    {
        int m = A.length;
        int n = A[0].length;

        if(A[0][0] == 1 || A[m-1][n-1] == 1) 
            return -1;
        
        boolean[][] visited = new boolean[A.length][A[0].length];

        int[] globalRows = new int[]{-1, -1, -1, 0, 1, 1, 1,  0};
        int[] globalCols = new int[]{-1,  0,  1, 1, 1, 0, -1, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!q.isEmpty())
        {
            Node poppedNode = q.remove();
            
            if(poppedNode.row == A.length - 1 && poppedNode.col == A[0].length - 1)
                return poppedNode.dist;
            
            for (int i = 0; i < 8; i++)
            {
                int newRow = poppedNode.row + globalRows[i];
                int newCol = poppedNode.col + globalCols[i];
                // int newDist = poppedNode.distanceFromSource;

                if(IsSafe(A, visited, newRow, newCol))
                {
                    // If not the ans, enqueue into the queue and mark as visited
                    q.add(new Node(newRow, newCol, poppedNode.dist + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return -1;
    }
    
    public boolean IsSafe(int[][] A, boolean[][] visited, int row, int col)
    {
        // Return true if it is safe to visit
        if(row >= 0 && row < A.length
            && col >= 0 && col < A[row].length
            && visited[row][col] == false && A[row][col] == 0)
            {
                return true;
            }

        return false;
    }
}