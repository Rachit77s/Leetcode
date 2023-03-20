class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
	     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
               int prev = (i == 0) ? 0 : flowerbed[i - 1];
               if(next == 0 && prev == 0) {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }
        
        return count == n;
    }
    
    public boolean Helper(int[] A, int n) 
    {
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] == 0)
            {
                
            }
        }
        
        return false;
    }
    
}


// 1 0 0 0 1     1

// 1 0 0 0 1     2

// 1 0 0 1 0 0 0 0 1   2



/*

1: 3
2: 3
3: 7

     1   1 
// 1 0 0 0 1     2

0 0 0 0

2: 3  No
2: 4  Y
3: 

*/