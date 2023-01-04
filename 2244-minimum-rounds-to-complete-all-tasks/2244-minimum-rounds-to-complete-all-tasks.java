class Solution {
    public int minimumRounds(int[] tasks) {
        
        return ApproachI(tasks);
    }
    
    public int ApproachI(int[] A)
    {
        // 12min
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++)
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        
        /*
            If the remainder of dividing the number by 3 is 1 or 2 then, again there can be two cases:
        If remainder is 1, i.e, lets take 7 frequency, then o o o o o o o the groups are something like this "ooo" "ooo" "o", i.e, one o is left alone so the solution is to break the second last group into two parts of 2 and 1 so that it becomes like: "ooo" "oo" "oo", i.e, one is added to the division by 3.
        If remainder is 2, i.e, lets take 8 frequency, then o o o o o o o o the groups are something like this "ooo" "ooo" "oo", i.e, two o are left so the solution is to just add 1,i.e, one group of two to the solution.
        
        */
        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {
            int frequency = e.getValue();
            
            if(frequency == 1)
                return -1;
            
            if(frequency % 3 == 0)
            {
                    count += frequency / 3;
            }
            else if(frequency - 2 >= 0)
            {
                count += frequency / 3 + 1;
            }
 
            // Wrong approach
//             while(frequency != 0)
//             {
//                 if(frequency == 1)
//                     return -1;
                
//                 if(value - 3 >= 0)
//                 {
//                     map.put(key, map.get(key) - 3);
//                     count++;
//                     value = value - 3;
//                 }
//                 else if(value - 2 >= 0)
//                 {
//                     map.put(key, map.get(key) - 2);
//                     count++;
//                     value = value - 2;
//                 }
//             }
    
            // if(map.get(key) == 0) 
            //     map.remove(key);
        }
        
        return count;
    }
}