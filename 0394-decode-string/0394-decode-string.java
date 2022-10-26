class Solution {
    public String decodeString(String s) {
        
        return Helper1(s);
    }
    
    // Good One: https://www.youtube.com/watch?v=SF2W6VDs7bc
    public String Helper1(String s)
    {
        // Keep track of counts
        Stack<Integer> countStk = new Stack<>();
        Stack<String> wordStk = new Stack<>();
        StringBuilder word = new StringBuilder();
        int number = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            // 300[a2[c]]
            
            if(ch >= '0' && ch <= '9')
            {
                number = number * 10 + ch - '0';
            }
            else if(ch == '[')
            {
                countStk.push(number);
                wordStk.push(word.toString());
                
                number = 0;
                word = new StringBuilder();
            }
            else if(ch == ']')
            {
                int cnt = countStk.pop();
                StringBuilder duplicatedWord = new StringBuilder(wordStk.pop());
                
                for(int j = 0; j < cnt; j++)
                    duplicatedWord.append(word);
                
                word = duplicatedWord;
            }
            else
                word.append(ch);
        }
        
        return word.toString();
    }
    
    // https://www.youtube.com/watch?v=0iQqj5egK9k
    public String Helper(String s)
    {
        // Keep track of counts
        Stack<Integer> countsStk = new Stack<>();
        Stack<String> resultStk = new Stack<>();
        
        String ans = "";
        int index = 0;
        
        while(index < s.length())
        {
            char ch = s.charAt(index);
            
            if(ch >= '0' && ch <= '9')
            {
                // Number can be large like 3650[ab]
                int count = 0;
                
                while(Character.isDigit(s.charAt(index)))
                {
                    count = count * 10 + s.charAt(index) - '0';
                    index += 1;
                }
                    
                countsStk.push(count);
            }
            // Append at opening bracket
            else if(ch == '[')
            {
                resultStk.push(ans);
                ans = "";
                index += 1;
            }
            else if(ch == ']')
            {
                StringBuilder sb = new StringBuilder(resultStk.pop());
                int cnt = countsStk.pop();
                
                for(int i = 0; i < cnt; i++)
                    sb.append(ans);
                
                ans = sb.toString();
                index += 1;
            }
            else
            {
                // Add onto the string 
                ans += ch;
                index += 1;
            }   
        }
        
        return ans;
    }
    
}
