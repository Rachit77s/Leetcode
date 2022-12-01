class Solution {
    public boolean halvesAreAlike(String s) {
        
        return Helper2(s);
        //return Helper(s);
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
    
    public boolean Helper2(String s) 
    {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int count = 0, i = 0, j = s.length() - 1;

        while(i < j){
            if(set.contains(s.charAt(i++)))
                ++count;
            if(set.contains(s.charAt(j--)))
                --count;
        }
        return count == 0;
    }
}