public class Solution {
    public bool IsValidSudoku(char[][] board) {
        return OptimizedCode3(board);
    }
    
    public bool OptimizedCode3(char[][] board)
    {
        HashSet<string> seenSet = new HashSet<string>();
        
        for (int i = 0; i < 9; ++i) 
        {
            for (int j = 0; j < 9; ++j) 
            {
                char value = board[i][j];
                
                if (value != '.')
                {
                    string rowKey = String.Format("r-{0}-{1}", i, value); 
                    string colKey = String.Format("c-{0}-{1}", j, value); 
                    string boardKey = String.Format("b-{0}-{1}-{2}", i/3, j/3, value); 
                            
                    if(seenSet.Contains(rowKey) || 
                       seenSet.Contains(colKey) || 
                       seenSet.Contains(boardKey))
                    {
                        return false;
                    }
                    else
                    {
                        seenSet.Add(rowKey);
                        seenSet.Add(colKey);
                        seenSet.Add(boardKey);
                    }
                }
            }
        }
        
        return true;
    }
}