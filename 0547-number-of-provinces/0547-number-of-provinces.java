class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    
    public void dfs(int[][] A, boolean[] visited, int node)
    {
        visited[node] = true;
        
        ArrayList<Integer> adjList = new ArrayList<>();
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[node][i] == 1 && !visited[i])
                dfs(A, visited, i);
        }
    }
}