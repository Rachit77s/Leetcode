class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int[] differenceArr = new int[capacity.length];
        
        for(int i = 0; i < capacity.length; i++)
        {
            differenceArr[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(differenceArr);
        
        int ans = 0;
        
        for(int i = 0; i < differenceArr.length; i++)
        {
            // Capacity is already full
            if(differenceArr[i] == 0)
                ans++;
            else
            {
                if(additionalRocks >= differenceArr[i])
                {
                    additionalRocks -= differenceArr[i];
                    ans++;
                }
                else
                    break;
            }
        }
        
        return ans;
    }
}



// 2 3 4 4
// 1 2 4 4

// 10 2 2
// 2 2 0

// 8 0 2