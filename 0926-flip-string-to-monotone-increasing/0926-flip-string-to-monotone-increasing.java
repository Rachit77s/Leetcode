class Solution {
    public int minFlipsMonoIncr(String s) {
        
        return OptimizedApproach(s);
        // return BruteForce(s);
        // return Helper(s);
    }
    
    // Subham: https://www.scaler.com/help_requests/662642/?ref=join-call-now
    public int BruteForce(String s)
    {
        // To make string monotonic increasing, at every index
        // We need to make all the, 1's at the left of the index to 0
        // And, all the 0's to the right of the index's to 1
        // The current char sign for whom we are calculating doesn't matter 
        // Because consider,  11011   so for 0 we will make left to it 0
        // And right to it as 1, and 0 wouldn't matter at all.
        
        int n = s.length();
        // int leftOnes = 0;
        // int rightZeroes = 0;
        int ans = Integer.MAX_VALUE;

        for(int index = 0; index < n; index++)
        {
            int leftOnes = 0;
            int rightZeroes = 0;
            
            for(int leftIdx = index - 1; leftIdx >= 0; leftIdx--)
            {
                if(s.charAt(leftIdx) == '1')
                    leftOnes++;
            }
            
            for(int rightIdx = index + 1; rightIdx < n; rightIdx++)
            {
                if(s.charAt(rightIdx) == '0')
                    rightZeroes++;
            }
            
            // We need to flip all the 1's on the left &
            // all the 0;s on the right, which will give us monotonic
            // The no of 1's on the left + no of 0's on right
            // together gives us the flips required
            ans = Math.min(ans, leftOnes + rightZeroes);
        }
        
        return ans;
    }
    
    
    public int OptimizedApproach(String s)
    {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        
        // Initialize two lists to store the number of 
        // 1s on the left and the number of 0s on the right
        // Calculate prefix 1's
        int[] prefixOnes = new int[n];
        if(s.charAt(0) == '1')
            prefixOnes[0] = 1;
        else
            prefixOnes[0] = 0;
        
        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i) == '1')
                prefixOnes[i] = prefixOnes[i - 1] + 1;
            else
                prefixOnes[i] = prefixOnes[i - 1] + 0;
        }
        
        // Calculate suffix 0's
        int[] suffixZeroes = new int[n];
        if(s.charAt(n-1) == '0')
            suffixZeroes[n-1] = 1;
        else
            suffixZeroes[n-1] = 0;
        
        for(int i = n - 2; i >= 0; i--)
        {
            if(s.charAt(i) == '0')
                suffixZeroes[i] = suffixZeroes[i + 1] + 1;
            else
                suffixZeroes[i] = suffixZeroes[i + 1] + 0;
        }
        
        
        // Calculate prefix 1's
        // int[] prefixOnes = new int[n];
        // for(int i = 0; i < n; i++)
        // {
        //     // If the character is a 1, add 1 to the prev element
        //     // Otherwise, add 0 to the prev element
        //     if(s.charAt(i) == '1') 
        //     {
        //         prefixOnes[i] = (i == 0 ? 0 : prefixOnes[i - 1]) + 1;
        //     } 
        //     else 
        //     {
        //         prefixOnes[i] = (i == 0 ? 0 : prefixOnes[i - 1]);
        //     }
        // }
        
        // // Calculate suffix 0's
        // int[] suffixZeroes = new int[n];
        // for(int i = n - 1; i >= 0; i--)
        // {
        //     // If the character is a 0, add 1 to the prev element
        //     // Otherwise, add 0 to the prev element
        //     if(s.charAt(i) == '0') 
        //     {
        //         suffixZeroes[i] = (i == n - 1 ? 0 : suffixZeroes[i + 1]) + 1;
        //     } 
        //     else 
        //     {
        //         suffixZeroes[i] = (i == n - 1 ? 0 : suffixZeroes[i + 1]);
        //     }
        // }
        
        for(int i = 0; i < n; i++)
            System.out.print(prefixOnes[i]);
        
        //System.out.println();
        
        //Collections.reverse(Arrays.asList(suffixZeroes));
        // for(int i = 0; i < n; i++)
        //     System.out.print(suffixZeroes[i]);
        
        for(int index = 0; index < n; index++)
        {
            // We need prefix sum till the curr index-1
            int leftOnes = (index == 0 ? 0 : prefixOnes[index - 1]);
            // We need suffix sum from the curr index+1
            int rightZeroes = (index == n-1 ? 0 : suffixZeroes[index + 1]);
            
            // int rightZeroes = suffixZeroes[index];
            
            ans = Math.min(ans, leftOnes + rightZeroes);
        }
        
        return ans;
    }
    
    public int OptimizedApproach2(String s)
    {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        
        // Initialize two lists to store the number of 
        // 1s on the left and the number of 0s on the right
        // Calculate prefix 1's
//         int[] prefixOnes = new int[n];
//         if(s.charAt(0) == '1')
//             prefixOnes[0] = 1;
//         else
//             prefixOnes[0] = 0;
        
//         for(int i = 1; i < n; i++)
//         {
//             if(s.charAt(i) == '1')
//                 prefixOnes[i] = prefixOnes[i - 1] + 1;
//             else
//                 prefixOnes[i] = prefixOnes[i - 1] + 0;
//         }
        
//         // Calculate suffix 0's
//         int[] suffixZeroes = new int[n];
//         if(s.charAt(n-1) == '0')
//             suffixZeroes[0] = 1;
//         else
//             suffixZeroes[0] = 0;
        
//         for(int i = n - 2; i >= 0; i--)
//         {
//             if(s.charAt(i) == '0')
//                 suffixZeroes[i] = suffixZeroes[i + 1] + 1;
//             else
//                 suffixZeroes[i] = suffixZeroes[i + 1] + 0;
//         }
        
        
        // Calculate prefix 1's
        int[] prefixOnes = new int[n];
        for(int i = 0; i < n; i++)
        {
            // If the character is a 1, add 1 to the prev element
            // Otherwise, add 0 to the prev element
            if(s.charAt(i) == '1') 
            {
                prefixOnes[i] = (i == 0 ? 0 : prefixOnes[i - 1]) + 1;
            } 
            else 
            {
                prefixOnes[i] = (i == 0 ? 0 : prefixOnes[i - 1]);
            }
        }
        
        // Calculate suffix 0's
        int[] suffixZeroes = new int[n];
        for(int i = n - 1; i >= 0; i--)
        {
            // If the character is a 0, add 1 to the prev element
            // Otherwise, add 0 to the prev element
            if(s.charAt(i) == '0') 
            {
                suffixZeroes[i] = (i == n - 1 ? 0 : suffixZeroes[i + 1]) + 1;
            } 
            else 
            {
                suffixZeroes[i] = (i == n - 1 ? 0 : suffixZeroes[i + 1]);
            }
        }
        
//         for(int i = 0; i < n; i++)
//             System.out.print(prefixOnes[i]);
        
//         System.out.println();
        
//         for(int i = 0; i < n; i++)
//             System.out.print(suffixZeroes[i]);
        
        for(int index = 0; index < n; index++)
        {
            // We need prefix sum till the curr index
            int leftOnes = (index == 0 ? 0 : prefixOnes[index - 1]);
            // We need suffix sum from the curr index
            int rightZeroes = (index == n-1 ? 0 : suffixZeroes[index + 1]);
            
            // int rightZeroes = suffixZeroes[index];
            
            ans = Math.min(ans, leftOnes + rightZeroes);
        }
        
        return ans;
    }
    
    
    public int Optimized2(String s)
    {
        // Initialize two lists to store the number of 1s on the left and the number of 0s on the right
        List<Integer> leftOnes = new ArrayList<>();
        List<Integer> rightZeroes = new ArrayList<>();

        // Add a 0 to the leftOnes list to represent the left side of the first character
        leftOnes.add(0);

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is a 1, add 1 to the last element in the leftOnes list and append it to the list
            // Otherwise, add 0 to the last element in the leftOnes list and append it to the list
            leftOnes.add(leftOnes.get(leftOnes.size() - 1) + (c == '1' ? 1 : 0));
        }

        // Add a 0 to the rightZeroes list to represent the right side of the last character
        rightZeroes.add(0);

        // Loop through the string backwards
        for (int i = s.length() - 1; i >= 0; i--) {
            // If the character is a 0, add 1 to the last element in the rightZeroes list and append it to the list
            // Otherwise, add 0 to the last element in the rightZeroes list and append it to the list
            rightZeroes.add(rightZeroes.get(rightZeroes.size() - 1) + (s.charAt(i) == '0' ? 1 : 0));
        }

        // Reverse the rightZeroes list so that it corresponds to the correct characters in the string
        Collections.reverse(rightZeroes);

        // Initialize a variable to store the minimum number of flips
        int minFlips = Integer.MAX_VALUE;

        // Loop through each index in the string
        for (int i = 0; i < s.length(); i++) {
            // Get the number of 1s on the left and the number of 0s on the right
            int leftOnesCount = leftOnes.get(i);
            int rightZeroesCount = rightZeroes.get(i + 1);
            // Update the minimum number of flips if the current combination requires fewer flips
            minFlips = Math.min(minFlips, leftOnesCount + rightZeroesCount);
        }

        // Return the minimum number of flips
        return minFlips;
    }
    
    // Very hard question
    public int Helper(String s)
    {
        int countOne = 0;
        int countFlip = 0;
        
        /*
            When We are traversing in the string S there will be two possibility

        Char=='1'
        It will not impact our minimum flips just keep the record of count of 1
        Char=='0'
        Here will be 2 cases
            Keep is as 0 and flip all the 1 so far ,for that we need to know about the count one so far
            Or else, Flip 0 to 1 and update our count_flip
        Take the minmum of count_flip and count_one and update the count_flip because we want minimum(dry run for 1110000)
        
        // if c is 1, then it will not inpact the minFlips
            // if c is 0, then 2 options we can do to make it mono incr
            // 1. keep it as 0, and flip all the preceeding 1 to 0, need to know the count of ones so far
            // 2. flip it to 1, will not need to do anything    
        */
 
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '1')
                countOne++;
            else
                countFlip++;
            
            countFlip = Math.min(countFlip, countOne);
        }
        
        return countFlip;
    }
}

// 00110 --> 00111
// 010110 -->01111