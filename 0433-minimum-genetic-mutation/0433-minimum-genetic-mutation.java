class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
    // NOTE: We need to make a mutation and check if it is a valid mutation 
    // by looking into bank. We can't directly go to final string and check it
    // in the bank. We need to perform mutation at every step and see it in bank.
        
        return MinMutationHelper(start, end, bank);
    }
    
    public int MinMutationHelper(String start, String end, String[] bank) 
    {
        if(start.equals(end)) 
            return 0;
        
        Set<String> bankSet = new HashSet<>();
        for(String b: bank) 
            bankSet.add(b);
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()) 
        {
            int size = queue.size();
            
            while(size -- > 0)
            {
                // get the gene string from the queue
                String str = queue.poll();
                
                // if it is same as `end`, that means we found the answer
                // if curr word equals to end, return ans from here
                if(str.equals(end)) 
                    return level;

                // otherwise, given a gene string with 8-character long
                // we can replace each character with "A", "C", "G" and "T"
                char[] currArray = str.toCharArray();
                
                // now for every index of curr word  8 chars only
                for(int i = 0; i < currArray.length; i++)
                {
                    // currArray[i] will be modified later, 
                    // hence store the original character here
                    char old = currArray[i];
                    
                    // we will try to replace every available choice
                    for(char c: charSet) 
                    {
                        currArray[i] = c;
                        String next = new String(currArray);
                        
                        // we can reach the next node if the next node hasn't been visited
                        // and the next node is available in `bank`
                        if(!visited.contains(next) && bankSet.contains(next)) 
                        {
                            visited.add(next);
                            queue.offer(next); // and mark it visited
                        }
                    }
                    
                    // now replace with again original character, for further check
                    currArray[i] = old;
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
    public int WrongApproach(String start, String end, String[] bank) 
    {
//         A wrong approach that I took while solving the question was just finding the mutation between the start and the end strings and then checking if end exists in bank or not.

// Our goal is to reach the gene string end starting from the gene string start. And all the valid mutations that you can make are given in the list bank.
// So you have to traverse from start across the bank and see if you can find the gene string end.
        
        if(start.length() <= 0 || end.length() <= 0 || bank.length <= 0)
            return -1;
        
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        
        for(int i = 0; i < bank.length; i++)
        {
            set.add(bank[i]);
        }
        
        int i = 0;
        while(i < start.length())
        {
            if(start.charAt(i) != end.charAt(i))
                ans++;
            
            i++;
        }
        
        // for(int x = 0; x < set.size(); x++)
        //     System.out.print(set[i]);
        
        if(set.contains(end))
            return ans;
        
        // Input:
        // "AACCTTGG"
        // "AATTCCGG"
        // ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
        // Output:
        // 4
        // Expected:
        // -1
        
        return -1;
    }
}