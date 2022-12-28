class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        return ApproachI(piles, k);
    }
    
    public int ApproachI(int[] A, int k)
    {
        // PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
        
        for(int i = 0; i < A.length; i++)
            maxPQ.add(A[i]);
        
        while(k != 0)
        {
            int num = maxPQ.poll();
            
            // Wrong
            // System.out.print(" Before:" + num);
            // num = (int)Math.floor(num/2);
            // System.out.print(" After:" + num);
            
            num = num - (int)Math.floor(num/2);
            maxPQ.add(num);
            
            k = k - 1;
        }
        
        int ans = 0;
        
        while(!maxPQ.isEmpty())
            ans += maxPQ.poll();

        return ans;
    }
}