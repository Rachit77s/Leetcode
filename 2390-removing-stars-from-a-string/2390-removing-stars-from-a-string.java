class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '*' && !stk.isEmpty())
            {
                stk.pop();
            }
            else
                stk.push(s.charAt(i));
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        // Iterate over each character in the stack and append it to the StringBuilder
        for (char c : stk) {
            sb.append(c);
        }
        
        // Convert the StringBuilder to a string and return it as the output
        return sb.toString();
    }
}