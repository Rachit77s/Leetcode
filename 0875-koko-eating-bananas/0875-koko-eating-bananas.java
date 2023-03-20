class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        return minEatingSpeedBS(piles, h);
        // return BinarySearch(piles, h);
        // return BruteForce(piles, h);
    }
    
    public int minEatingSpeedBS(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private int f(int[] piles, int speed) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / speed;
            if (piles[i] % speed > 0) hours++;
        }
        return hours;
    }
    
    // TC: O(n logn)
    public int BinarySearch(int[] A, int h) 
    {

        int maxNumber = 1000000000;//FindMaxElement(A);
        int left = 1;
        int right = maxNumber;

//         piles = [3,6,7,11], h = 8

//               0  1  2  3  4  5  6  7  8  9    10
//          k = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

//         L: 1     1    4   4

//         R: 11   5    5   3

//         M:  6    3   4   break


        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(IsAbleToEat(A, mid, h) == true)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return left;
    }


    public boolean IsAbleToEat(int[] A, int k, int h)
    {
        int numberOfHours = 0;
        //  piles = [3,6,7,11]

        for(int i = 0; i < A.length; i++)
        {
            numberOfHours += A[i] / k;
             
            if(A[i] % k != 0)
                numberOfHours++;	   
        }   

        if(numberOfHours <= h)
            return true;

        return false;
    }

    public int FindMaxElement(int[] A)
    {
        int maxNumber = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++)
        {

            if(A[i] > maxNumber)
                maxNumber = A[i];
        }   
        
       return maxNumber;
    }

    
    public int BruteForce(int[] piles, int h) 
    {
        // Determine the starting eating speed of Koko
        // There are no lower eating speed than the average speed,
        // because if it was a case, we will not be able to finish all piles within H hours.
        double sum = 0.;
        for (int pile : piles) {
            sum += pile;
        }
        int speed = (int)Math.ceil(sum / h);
        
        // Continuously increment the speed by 1 until
        // Koko can eat all bananas within H hours range
        while (true) 
        {
            int hours = 0;
            
            for (int pile : piles) 
            {
                hours += (int)Math.ceil((double)pile / speed);
                if (hours > h) {
                    break;
                }
            }
            
            if (hours <= h) {
                break;
            }
            ++speed;
        }
        return speed;
        
        
    }
}