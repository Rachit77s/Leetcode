class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        return Comments(arr);
        // return BruteForce(arr);
    }
    
    public int BruteForce(int[] A)
    {
        int sum = 0;
        //int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < A.length; i++) 
        {
            int min = A[i];
            
            for (int j = i; j < A.length; j++)
            {
                if(min > A[j])
                    min = A[j];
                
                sum += min;
                sum = sum % 1000000007;
            }   
        }
        
        return sum;     /// % 1000000007;
    }
    
    public int Comments(int[] arr) {
      // initialize previous less element and next less element of 
      // each element in the array
        
    int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        // the distance of next or previous less
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++){
            right[i] = n - i;
        }

        for(int i = 0; i < n; i ++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        int res = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < n; i++){
            res = (int) ((res + (long)arr[i]*left[i]*right[i])% mod);
        }
        return res;
    }
}


