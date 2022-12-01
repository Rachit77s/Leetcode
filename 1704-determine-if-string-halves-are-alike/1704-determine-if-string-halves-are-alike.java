class Solution {
    public boolean halvesAreAlike(String s) {
        
        return Helper(s);
    }
    
    public boolean Helper(String s) 
    {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int k = s.length() / 2;
        
        int firstHalf = 0;
        int secondHalf = 0;
        for(int i = 0; i < s.length() / 2; i++)
        {
            if(set.contains(s.charAt(i)))
                firstHalf++;
            
            if(set.contains(s.charAt(i+k)))
                secondHalf++;
        }
        
        if(firstHalf == secondHalf)
            return true;
        
        return false;
    }
}