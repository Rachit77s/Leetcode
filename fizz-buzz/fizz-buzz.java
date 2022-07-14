class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        
        boolean isDiv = false;
        for(int i = 1; i <= n; i++)
        {
            if(i % 3 == 0 && i % 5 == 0)
            {
                isDiv = false;
                ans.add("FizzBuzz");
            }
            else if(i % 3 == 0 && !isDiv)
            {
                ans.add("Fizz");
            }
            else if(i % 5 == 0 && !isDiv)
            {
                ans.add("Buzz");
            }
            else
            {
                ans.add(Integer.toString(i));
            }
        }
        
        return ans;
    }
}