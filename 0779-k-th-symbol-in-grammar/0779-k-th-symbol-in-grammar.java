class Solution {
    public int kthGrammar(int N, int K) {
        
                if(N==1) return 0;
        if(K%2==0){
            if (kthGrammar(N-1,K/2)==0) return 1;
            else return 0;
        }
        else{
            if(kthGrammar(N-1,(K+1)/2)==0) return 0;
            else return 1;
        }
        
    }
    
    public int Helper(int n, int K)
    {

        // Draw its Binary Tree and see the observations
//         if(n == 1)
//             return 0;
        
//         // Tricky
//         int parent = Helper(n-1, k / 2 + k % 2);
        
//         if(parent == 0)
//         {
//             if((k & 1) == 0)
//                 return 0;
//             else
//                 return 1;
//         }
//         else
//         {
//             if((k & 1) == 0)
//                 return 1;
//             else 
//                 return 0;
//         }
        
        return 1;
    }
}