class Solution {
    public int myAtoi(String s) {
        
        return UsingLong(s);
    }
    
    // https://www.youtube.com/watch?v=qZoFJKyHQ98
    public int UsingLong(String s)
    {
        int n = s.length();
        int index = 0;
        int sign = 1;
        long number = 0;
        
        // Check if empty string
        if(s.length() == 0)
            return 0;
        
        // remove white spaces from the string
        while(index < n && s.charAt(index) == ' ')
            index++;
        
        // Edge Case of returning 0;
        if(index == n)
            return 0;
        
        // get the sign
        if(s.charAt(index) == '+')
        {
            index++;
            sign = 1;
        }
        else if(s.charAt(index) == '-')
        {
            index++;
            sign = -1;
        }
        
        while(index < n)
        {
            int currentDigit = s.charAt(index) - '0';
            
            // For edge case: 4193abcd
            if(currentDigit < 0 || currentDigit > 9) 
                break;
        
            number = number * 10 + currentDigit;
            
            // Important: after converting the number, check for overflow, else wrong answer.           
            if(sign == 1 && number > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
           
            if(sign == -1 && -1 * number < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
                       
            index++;
        }
        
        System.out.print(number * sign);
        return (int) number * sign;
    }
    
    public int LeetcodeDiscussMethod(String s)
    {
        // https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/884/discuss/4643/Java-Solution-with-4-steps-explanations

        int index = 0;
        int total = 0;
        int sign = 1;
        int n = s.length();
        
        // Check if empty string
        if(s.length() == 0)
            return 0;
        
        // remove white spaces from the string
        while(index < n && s.charAt(index) == ' ')
            index++;
        
        // Edge Case of returning 0;
        if(index == n)
            return 0;
        
        // get the sign
        if(s.charAt(index) == '+')
        {
            index++;
            sign = 1;
        }
        else if(s.charAt(index) == '-')
        {
            index++;
            sign = -1;
        }
        
        // convert to the actual number and make sure it's not overflow
        while(index < n)
        {
            int digit = s.charAt(index) - '0';
            
            // For edge case: 4193abcd
            if(digit < 0 || digit > 9) 
                break;
            
            // check for overflow
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && 
               Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
			    // if (sign == 1 && digit > Integer.MAX_VALUE)
			    // return Integer.MAX_VALUE;
			    // if (sign == -1 && (-1) * digit < Integer.MIN_VALUE)
			    // return Integer.MIN_VALUE;
            
            total = total*10 + digit;
            
            index++; // don't forget to increment the counter
        }
        
        return total * sign;
    }
    
    public static int HowNotToSolve(String s)
    {
        //         String temp = "";
        
        //         boolean isNegative = false;
        //         boolean isFirstZero = false;

        //         for(int i = 0; i < s.length(); i++)
        //         {
        //             while(s.charAt(i) == ' ')
        //                 i++;

        //             if(i < s.length())
        //             {
        //                 if(s.charAt(i) == '0' && isFirstZero == false)
        //                 {
        //                     isFirstZero = true;
        //                 }                  
        //                 else if(s.charAt(i) == '-')
        //                     isNegative = true;
        //                 else if(Character.isDigit(s.charAt(i)))
        //                 {
        //                     temp += s.charAt(i);
        //                 }
        //             }
        //         }

        //         if(temp.length() != 0)
        //         {
        //             //double digit = Double.parseDouble(temp);

        //             int sum = sum * 10 + str.charAt(i) - '0';
        //             if (sign == 1 && sum > Integer.MAX_VALUE)
        //                 return Integer.MAX_VALUE;
        //             if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
        //                 return Integer.MIN_VALUE;
        //             if(digit >= 2*31 - 1)
        //                 return 2*31 - 1;
        //             else if(digit <= -2*31)
        //                 return -2*31;

        //             if(isNegative == true)
        //                 digit = -digit;

        //             return (int)digit;
        //         }

                 return 0;
    }
}

    
    