class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        return OptimizedCode1(board);
    }
    
    public boolean OptimizedCode1(char[][] board)
    {
        HashSet seenSet = new HashSet();
        
        for (int i = 0; i < 9; ++i) 
        {
            for (int j = 0; j < 9; ++j) 
            {
                char number = board[i][j];
                
                if (number != '.')
                {
                    if(!seenSet.add(number + " in row " + i) ||
                       !seenSet.add(number + " in col " + j) ||
                       !seenSet.add(number + " in block " + i/3 + "-" + j/3))
                    {
                        return false;
                    }       
                }
            }
        }
        
        return true;
    }
    
    public boolean OptimizedCode2(char[][] board)
    {
        HashSet seenSet = new HashSet();
        
        for (int i = 0; i < 9; ++i) 
        {
            for (int j = 0; j < 9; ++j) 
            {
                char number = board[i][j];
                
                if (number != '.')
                {
                    if(seenSet.contains(number))
                    {
                        return false;
                    }
                    else
                    {
                        seenSet.add(number + " in row " + i);
                        seenSet.add(number + " in col " + j);
                        seenSet.add(number + " in block " + i/3 + "-" + j/3);
                    }
                }
            }
        }
        
        return true;
    }
}