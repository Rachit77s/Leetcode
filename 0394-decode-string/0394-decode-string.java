class Solution {
    public String decodeString(String s) {
        
        return RecursiveHelper2(s);
        // return RecursiveHelper(s);
        // return Helper1(s);
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
    
    public String RecursiveHelper(String s)
    {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) 
            queue.offer(c);
        
        return Recursive(queue);
    }
    public String Recursive(Deque<Character> queue)
    {
        // Every time we meet a '[', we treat it as a subproblem so call our recursive function to get the content in that '[' and ']'. After that, repeat that content for 'num' times.
        // Every time we meet a ']', we know a subproblem finished and just return the 'word' we got in this subproblem.

        StringBuilder sb = new StringBuilder();
        int number = 0;
        
        while (!queue.isEmpty()) 
        {
            char ch = queue.poll();
            
            if(ch >= '0' && ch <= '9')
                number = number * 10 + ch - '0';
            else if(ch == '[')
            {
                // Start a new chunk, give this task to recursion function
                String sub = Recursive(queue);
                
                for (int i = 0; i < number; i++) 
                    sb.append(sub);   
                
                number = 0;
            }
            // We have finished this [] chunk, return string to upper caller
            else if(ch == ']')
            {
                break;
            }
            else
                sb.append(ch);
        }
        
        return sb.toString();
    }
    
    
    public String RecursiveHelper2(String s)
    {
        int i[] = {0};
        return Recursive2(s, i);
    }
    
    // Comments: https://leetcode.com/problems/decode-string/discuss/87543/0ms-simple-C%2B%2B-solution
    public String Recursive2(String s, int[] i)
    {
        StringBuilder res = new StringBuilder();
        
        while(i[0] < s.length() && s.charAt(i[0]) != ']')
        {
            if (!Character.isDigit(s.charAt(i[0]))) {
                res.append(s.charAt(i[0]++));
            }
            else 
            {
                int counter = 0;
                while (Character.isDigit(s.charAt(i[0]))) {
                    counter = counter * 10 + s.charAt(i[0]++) - '0';
                }
                
                i[0]++; // Skipping [
                
                String subString = Recursive2(s, i);
                
                i[0]++;   //']'
                
                while (counter-- > 0) {
                    res.append(subString);
                }
            }
        }
        
        return res.toString();
    }
}
