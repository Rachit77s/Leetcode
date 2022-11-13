class MedianFinder {

    // By observation Numbers on the left side of Median are smaller than it, and the numbers on the right side of Median are greater than it. 
// Median would be largest on the left side and smallest on the right side. Hence MaxHeap on the left side and MinHeap on the right side.
    
    // Code: Anuj: https://www.youtube.com/watch?v=Yv2jzDzYlp8
    
    // Assumption: MaxHeap can have atmost 1 more element than minHeap, 
    // this is to find the ans for the odd length case.
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    /*
        1) store first half in maxh, second half in minh
        2) at any point of time maxh can have atmost 1 element more than minh (==1 is the case when we have odd number of elements)
    */
    public void addNum(int num) 
    {
        // If number is less than maxHeap, add it to maxHeap
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        // If maxHeap size is more than minHeap+1, pop element and add to minHp
        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() 
    {
        // Even case
        if(maxHeap.size() == minHeap.size())
        {
            // Take the average of middle 2 elements of max and minHeap resp
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
            
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */