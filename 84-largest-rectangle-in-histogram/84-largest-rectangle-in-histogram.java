class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // https://www.youtube.com/watch?v=lJLcqDsmYfg&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=61
        return Optimized(heights);
    }
    
    public int Optimized(int[] A)
    {
        int area = Integer.MIN_VALUE;
        int[] right = NextSmallerElementRight(A);
        int[] left = PrevSmallerElementLeft(A);
            
        for(int i = 0; i < A.length; i++)
        {
            int L = left[i];
            int R = right[i];
            
            if(R == -1)
                R = A.length;
                            
            int breadthOrWidth = R - L - 1;
            int length = A[i];
            int newArea = length * breadthOrWidth;
            
            area = Math.max(newArea, area);
        }
        
        return area;
    }
    
    public int[] PrevSmallerElementLeft(int[] A)
    {
        int[] prevSmallerElementLeft = new int[A.length];
        Stack<Integer> stk = new Stack();
        stk.push(-1);
        
        for(int i = 0; i < A.length; i++)
        {
            int currElement = A[i];
            
            while(stk.peek() != -1 && A[stk.peek()] >= currElement)
            {
                stk.pop();
            }
            
            prevSmallerElementLeft[i] = stk.peek();
            stk.push(i);
        }
        
        return prevSmallerElementLeft;
    }
    
    public int[] NextSmallerElementRight(int[] A)
    {
        int[] nextSmallerElementRight = new int[A.length];
        Stack<Integer> stk = new Stack();
        stk.push(-1);
        
        for(int i = A.length - 1; i >= 0; i--)
        {
            int currElement = A[i];
        
            // Till the time stk top is greater than current element, pop the stack. Or in other words, Until we find a smaller element than the current element, pop the stack.
            while(stk.peek() != -1 && A[stk.peek()] >= currElement)
            {
                stk.pop();
            }
            
            // Stack top is ans
            nextSmallerElementRight[i] = stk.peek();
            stk.push(i);
        }
        
        return nextSmallerElementRight;
    }
}