class Solution {
    public int lastStoneWeight(int[] stones) {
        
        return Helper(stones);
    }
    
    public int Helper(int[] stones) 
    {
        // Java is internally a MinHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        // To make the min heap to max heap, reverse the polarity
        for (int a : stones)
            maxHeap.offer(-a);
        
        // Alternate way to create a MaxHeap Queue
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        // for (int a : A)
        //     pq.offer(a);
        
        
        while(maxHeap.size() > 1)
        {
            // Flip the sign again to make original numbers
            int stoneOne = -(maxHeap.remove());
            int stoneTwo = -(maxHeap.remove());
            
            if(stoneOne != stoneTwo)
            {
                // Flip the sign again to make maxHeap
                maxHeap.add(-(stoneOne - stoneTwo));
            }
        }
        
        // If heap is empty return 0, else return original number
        return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
    }
    
    public int Helper2(int[] stones) 
    {
        Queue<Integer> maxPq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        
        for (int stone : stones) 
            maxPq.add(stone);
        
        while (maxPq.size() >= 2) 
        {
            int y = maxPq.poll();
            int x = maxPq.poll();
            if (y > x) {
                maxPq.add(y - x);
            }
        }
        
        return maxPq.isEmpty() ? 0 : maxPq.peek();
    }
}