class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success)     {
        return Approach1(spells, potions, success);
        // return Bruteforce(spells, potions, success);
    }
    
    public int[] Approach1(int[] spells, int[] potions, long success) 
    {
        int[] ans = new int[spells.length];
        
        Arrays.sort(potions);
        
        for(int i = 0; i < spells.length; i++)
        {
            int count = 0;
            
            int left = 0;
            int right = potions.length; // Important size
            
            while(left < right)
            {
                int mid = left + (right - left) / 2;
                
                long product = (long) spells[i] * potions[mid];
                
                if(product >= success)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[i] = potions.length - right;
        }
        
        return ans;
    }
    
    public int[] Bruteforce(int[] spells, int[] potions, long success) 
    {
        int[] ans = new int[spells.length];
        
        for(int i = 0; i < spells.length; i++)
        {
            int count = 0;
            
            for(int j = 0; j < potions.length; j++)
            {
                if(spells[i] * potions[j] >= success)
                    count++;
            }
            
            ans[i] = count;
        }
        
        return ans;
    }
}