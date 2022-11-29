class RandomizedSet {

    ArrayList<Integer> ans;
    HashMap<Integer, Integer> map;
    java.util.Random rand;// = new java.util.Random();
    
    public RandomizedSet() {
        ans = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        
        // If present return false
        if(map.containsKey(val))
            return false;
        
        int index = ans.size();
        ans.add(val);
        
        map.put(val, index);
        
        // System.out.print("Inserted: " + val + " ");
        return true;
    }
    
    public boolean remove(int val) {
        
        // Returns true if the item was present
        if(map.containsKey(val))
        {
            int idxOfVal = map.get(val);
            map.remove(val);
            
            ans.remove(Integer.valueOf(val));
            
            // System.out.print("Removed: " + val + " ");
            return true;
        }
        
        return false;
    }
    
    public int getRandom() {
        
        // for(int r : ans)
        //     System.out.print("GetRandom: " + r + " ");
        
        return ans.get( rand.nextInt(ans.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */