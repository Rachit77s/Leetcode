class Solution {
    public String intToRoman(int num) {
        
        return Helper3(num);
    }
    
    public String Helper(int num) 
    {
        // 13
        int[] integer = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        //iterate until the number becomes zero, NO NEED to go until the last element
        while(num != 0)
        {
            while(num >= integer[i])
            {
                num = num - integer[i];
                sb.append(roman[i]);
            }
            
            i++;
        }
        
        return sb.toString();
    }
    
    public String Helper2(int num) 
    {
        // 13
        int[] integer = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < integer.length; i++)
        {
            while(num >= integer[i])
            {
                num = num - integer[i];
                sb.append(roman[i]);
            }
        }
        
        return sb.toString();
    }
    
    public String Helper3(int num) 
    {
        // 13                //    0     1    2    3    4    5   6   7   8   9  10  11  12
        int[] integer = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,  4,  1};
        String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < integer.length; i++)
        {
            while(num / integer[i] != 0 && num != 0)
            {
                int count = num / integer[i];
                
                while(count-- != 0)
                    sb.append(roman[i]);
                
                num = num % integer[i];
            }
        }
        
        return sb.toString();
    }
}


// Roman numerals are usually written largest to smallest from left to right. XVII 27

// 58/10: 5   58%10: 8
// 58/10 = 5
// 58%10 = 8
// 20      0
