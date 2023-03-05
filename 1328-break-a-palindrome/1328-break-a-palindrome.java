class Solution {
    public String breakPalindrome(String palindrome) {
        
        return Helper(palindrome);
    }
    
    public String Helper(String A) 
    {
        if(A.length() == 1)
            return "";
        
        StringBuilder sb = new StringBuilder(A);
        
        int countA = 0;
        boolean isChanged = false;
        
        for(int i = 0; i < sb.length(); i++)
        {
            if(sb.charAt(i) == 'a')
                countA++;
        }
        
        if(countA == A.length() - 1)
        {
            sb.setCharAt(sb.length() - 1, 'b');
            return sb.toString();
        }
            
        
        for(int i = 0; i < sb.length(); i++)
        {
            if(countA == A.length() - 2 && sb.length() % 2 == 1)
            {
                if(sb.charAt(i) != 'a')
                {
                    if(i + 1 < sb.length())
                        sb.setCharAt(i, 'a');

                    isChanged = true;
                    break;
                }
            }
            else if(sb.charAt(i) != 'a')
            {
                sb.setCharAt(i, 'a');

                isChanged = true;
                break;
            }
                
        }
        
        if(isChanged == false)
            sb.setCharAt(sb.length() - 1, 'b');
        
        return sb.toString();
    }
}