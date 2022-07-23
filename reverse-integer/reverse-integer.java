class Solution {
    public int reverse(int x) {
//         int num = 0;
//         boolean isNegative = false;
        
//         if(x < 0)
//         {
//             isNegative = true;
//             x = -x;
//         }
            
        
//         //123
//         while(x != 0)
//         {
//             num = num * 10 + x % 10;
            
//             if((rev - x % 10) / 10 != prevRev){
//                 return 0;
//             }
            
//             x = x / 10;
            
//             if( num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
//                 return 0;
//         }
        
//         if(isNegative == true)
//         {
//             num *= -1; 
//             //System.out.print(num);
//         }
        
        int prevRev = 0 , rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            if((rev - x % 10) / 10 != prevRev){
                return 0;
            }
            prevRev = rev;
            x= x/10;
        }
        return rev;

        //return num;
    }
}