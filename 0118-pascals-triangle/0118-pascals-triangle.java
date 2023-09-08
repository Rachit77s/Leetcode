class Solution {
    public List<List<Integer>> generate(int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {   
            List<Integer> temp = new ArrayList<>();
            
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 || j == i)
                {
                    temp.add(1);
                }
                else
                {
                    int sum = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                    temp.add(sum);
                }
            }
            
            ans.add(temp);
            //System.out.println();
        }
        
        return ans;
    }
}


/*

    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
      
*/