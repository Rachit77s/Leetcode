class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        return M1(nums, k);
        // return BruteForce(nums, k);
    }
    
    public int BruteForce(int[] A, int k) 
    {
        int count = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            int sum = 0;
            
            for(int j = i; j < A.length; j++)
            {
                sum += A[j];
                
                if(sum % k == 0)
                    count++;
            }
        }
        
        return count;
    }
    
    public int M1(int[] A, int k) 
    {
        // We will trace the remainder of running sum
        int count = 0;
        int runningSum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Edge case
        map.put(0, 1);
        
        
        for(int i = 0; i < A.length; i++)
        {
            runningSum += A[i];
            
            int remainder = runningSum % k;
            
            // If remainder is -ve, make it +ve by adding k
            if(remainder < 0)
                remainder += k;
            
            if(map.containsKey(remainder))
                count += map.get(remainder);
            
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}

//           4 5 0 -2 -3 1
// prefix =  4 9 9  7  4 5
//           1 -4 -4 -2 1 0

// -3 -2 0 1 4 5
