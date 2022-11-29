class RandomizedSet {

    
    // Neetcode: https://www.youtube.com/watch?v=j4KwhBziOpg
    ArrayList<Integer> list;
    
    // It will contain array element and its index in the arraylist
    HashMap<Integer, Integer> map;
    java.util.Random rand;// = new java.util.Random();
    
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;

        map.putIfAbsent(val, list.size());
        list.add(val);
        
        return true;
    }
    
    // Tricky Part
    public boolean remove(int val) {
        
        // For this in O(1), we will place the element at the end, and remove it.
        if(!map.containsKey(val))
            return false;
        
        // Java: set(int index, E element)
        
        // Get idx of element to be removed
        int eleToRemoveIndex = map.get(val);
        
        // SWAP
        // Get the idx of the element to be removed.
        // Put the last element at the idx of the ele which is to be removed.
        // Put the idx to be removed at the last idx and remove it.
        int lastIdxElement = list.get(list.size() - 1);
        list.set(eleToRemoveIndex, lastIdxElement);
        // list.set(list.size() - 1, val); Not needed
        
        // Update the lastEleIdx in the map
        map.put(lastIdxElement, eleToRemoveIndex);
        
        map.remove(val);
        list.remove(list.size() - 1);
        
        return true;
        
    }
    
    public int getRandom() {
        
        int n = rand.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */