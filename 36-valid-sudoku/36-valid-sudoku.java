class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //return BetterApproach(board);
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
    
    // Wrong
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
    
    // Wrong
    public boolean BetterApproach(char[][] board) 
    {
        for(int i = 0; i < 9; i++)
        {
            HashSet<Character> rowsSet = new HashSet<Character>();
            HashSet<Character> columnsSet = new HashSet<Character>();
            HashSet<Character> boxesSet = new HashSet<Character>();
            
            for (int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
//                     if(rowsSet.contains(board[i][j]))  
//                         return false;
//                     else
//                         rowsSet.add(board[i][j]);
                        
//                     if(columnsSet.contains(board[j][i]))
//                         return false;
//                     else
//                         rowsSet.add(board[i][j]);
                                     
//                     if(boxesSet.contains(board[i/3][j/3]))
//                         return false;
//                     else
//                         boxesSet.add(board[i/3][j/3]);
                    
                    
                    if(rowsSet.contains(board[i][j])
                        || columnsSet.contains(board[i][j]) 
                        || boxesSet.contains(board[i/3][j/3])
                      )
                            return false;
                                                                          
                    rowsSet.add(board[i][j]);
                    rowsSet.add(board[i][j]);
                    boxesSet.add(board[i/3][j/3]);
                                                                          
                }
                
            }
        }
        
        return true;
    }
}