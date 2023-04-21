class Solution {
    public int mySqrt(int x) {
        
        // Search from 1 to x/2 for linear search
        
        if (0 == x) 
            return 0;
        int left = 1, right = x;
        int ans = 0;
        
        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
        
//         long left = 1;
//         long right = x;
        
//         while(left < right)
//         {
//             long mid = left + (right - left) / 2;
            
//             if(mid * mid >= x)
//                 right = mid;
//             else
//                 left = mid + 1;
//         }
        
//         return (int)left;
    }
}