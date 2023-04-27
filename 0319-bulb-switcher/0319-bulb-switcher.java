class Solution {
    public int bulbSwitch(int n) {
        
        // Perfect Squares
        return (int) Math.sqrt(n);
        // return BruteForce(n);
    }
    
    public int BruteForce(int n) 
    {
        
        HashMap<Integer, ArrayList<Integer>> map = Factorization(n);
        
        int countOfOddFactors = 0;
        
        for (int i = 1; i <= n; i++) 
        {
            if(map.get(i).size() % 2 == 1)
                countOfOddFactors+=1;
        }
        
        
        return countOfOddFactors;
    }
    
    public HashMap<Integer, ArrayList<Integer>> Factorization(int n)
    {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        ArrayList<Integer> fac = new ArrayList<Integer>();
        fac.add(1);
        map.put(1,fac);
        
        for (int i = 2; i <= n; i++) 
        {
            ArrayList<Integer> factors = new ArrayList<Integer>();
            
            for (int j = 1; j <= i; j++) 
            {
                if (i % j == 0) {
                    factors.add(j);
                }
            }
            
            map.put(i, factors);
        }

        // System.out.println("The factors of numbers from 1 to 1000 are:");
        // for (int i = 0; i < map.size(); i++) {
        //     System.out.print("Factors of " + (i+1) + ": " + map.get(i));
        // }
        
        // System.out.println("Factors of 2" + ": " + map.get(2));
        // System.out.println("Factors of 3" + ": " + map.get(3));
        // System.out.println("Factors of 4" + ": " + map.get(4));
        // System.out.println("Factors of 5" + ": " + map.get(5));
        
        return map;
    }
}
