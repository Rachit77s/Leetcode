class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        return Pascal(numRows);
    }
    
    public List<List<Integer>> Pascal(int A)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i = 0; i < A; i++)
        {
            List<Integer> temp = new ArrayList<>();
            
            // To handle edge cases j < i+1
            // M-I
            for(int j = 0; j < i+ 1; j++)
            {
                if(j == 0 || j == i)
                    temp.add(1);
                else
                {
                    int sum = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                    //int sum = ans.get(i - 1).get(j - 1);
                    temp.add(sum);
                }
            }
            
            // M-II
            // temp.add(0, 1);
            // for(int j = 1; j < i+1; j++)
            // {
            //     if(j == 0 || j == i)
            //         temp.add(1);
            //     else
            //     {
            //         int sum = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
            //         //int sum = ans.get(i - 1).get(j - 1);
            //         temp.add(sum);
            //     }
            // }
            
            ans.add(temp);
        }
        
        return ans;
    }
}

// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// 1 5 10 10 5 1
// 1 6 15 20 15 6 1
    
    