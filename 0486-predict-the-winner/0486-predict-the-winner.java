class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        return Helper(nums);
    }
    
    // Babbar: Paid RecursionCourse 
    public boolean Helper(int[] A)
    {
        int player1Score = ScoreCalculatorHelper(A, 0, A.length - 1);
        
        int totalScore = 0;
        for(int i = 0; i < A.length; i++)
            totalScore += A[i];
        
        int player2Score = totalScore - player1Score;
        
        if(player1Score >= player2Score)
            return true;
        
        return false;
    }
    
    public int ScoreCalculatorHelper(int[] A, int left, int right)
    {
        if(left > right)
            return 0;
        
        if(left == right)
            return A[left];
        
        // P1 picks left most element, so now P2 will pick.
        // P2 will pick up max element, hence leaving P1 with Min of all the elements.
        // P2 then can pick leftmost element leaving P1 to pick from index (left + 2, right)
        // or P2 can pick rightmost element leaving P1 to pick from index (left+1, right-1)
        int player1Option1 = A[left] + 
            Math.min(ScoreCalculatorHelper(A, left + 2, right), 
                     ScoreCalculatorHelper(A, left + 1, right - 1));
        
        // P1 picks right most element, so now P2 will pick, leaving P1 with min of all.
        int player1Option2 = A[right] + 
            Math.min(ScoreCalculatorHelper(A, left + 1, right - 1), 
                     ScoreCalculatorHelper(A, left, right - 2));
        
        int player1Maxscore = Math.max(player1Option1, player1Option2);
        
        return player1Maxscore;
    }
}