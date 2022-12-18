class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
          
        return StackSolution(temperatures);      
    }
    
    public int[] StackSolution(int[] temperatures)
    {
        Stack<Integer> stk = new Stack<Integer>();
        
        int[] ans = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length; i++) 
        {
            while(stk.size() != 0 && temperatures[i] > temperatures[stk.peek()])
            {
                //Input:     //0  1  2  3  4  5  6  7  8  9
                //            [55,38,53,81,61,93,97,32,43,78]
                //Output:
                //            [3, 1, 1, 2, 1, 1, 1, 1, 0, 0]
                //Expected:
                //            [3, 1, 1, 2, 1, 1, 0, 1, 1, 0]
                
                int idx = stk.pop();
                ans[idx] = i - idx;
            }
            
            //// Push the current index
            stk.push(i);
        }
        
        return ans;
    }
    
    public int[] Bruteforce(int[] temperatures)
    {
        int[] ans = new int[temperatures.length];
        int idx = 0;
        int count = 0;
        
        for(int i=0; i<ans.length; i++)
            ans[i] = 0;
        
        for(int i=0; i<temperatures.length; i++)
        {
            for(int j=i+1; j<temperatures.length; j++)
            {
                if(temperatures[j] > temperatures[i])
                {
                    idx = j-i;
                    ans[i] = idx;
                    //count++;
                    break;
                }
            }
        }
        
        return ans;
    }
}