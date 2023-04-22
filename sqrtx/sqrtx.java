class Solution {
    public int mySqrt(int x) {
        
        // Search from 1 to x/2 for linear search
        
        if(x == 0 || x == 1)
            return x;
        int left = 1; 
        int right = x/2 +2;
        
        while (left < right) {            
            int mid = left + (right-left+1)/2;            
            if (mid > x/mid) {
                right = mid - 1;
            }
            else left = mid;
        }        
        return left;
        
    }
}