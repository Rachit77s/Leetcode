class Solution {
    public boolean exist(char[][] board, String word) {
        
        return Helper(board, word);
    }
    
    // Codebix: https://www.youtube.com/watch?v=WO7uDd7ShW0
    public boolean Helper(char[][] board, String word) 
    {
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[0].length; j++)
            {
                // If we find the char to match, then only go ahead for DFS
                if(board[i][j] == word.charAt(0) && DFS(board, i, j, 0, word))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean DFS(char[][] board, int i, int j, int index, String word) 
    {
        if(index == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
           board[i][j] != word.charAt(index))
            return false;
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        boolean ans = DFS(board, i+1, j, index+1, word) || 
                      DFS(board, i-1, j, index+1, word) || 
                      DFS(board, i, j+1, index+1, word) || 
                      DFS(board, i, j-1, index+1, word);
        
        // Backtrack
        board[i][j] = temp;
        
        return ans;
    }
}