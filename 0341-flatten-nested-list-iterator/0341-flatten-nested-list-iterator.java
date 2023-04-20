/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Subham: https://www.scaler.com/help_requests/697220/?ref=join-call-now
public class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> ansList;
    int index;  // To iterate ansList
    
    
    public NestedIterator(List<NestedInteger> nestedList) {
        
        ansList = new ArrayList<>();
        index = 0;
        
        FlattenList(nestedList);
    }
    
    public void FlattenList(List<NestedInteger> nestedList) 
    {
       for(NestedInteger nested : nestedList)
       {
           // If it is single integer
           if(nested.isInteger())
               ansList.add(nested.getInteger());
           else // call recursion
               FlattenList(nested.getList());
       }
    }

    @Override
    public Integer next() {
        Integer val = ansList.get(index);
        index++;
        return val;
    }

    @Override
    public boolean hasNext() {
        if(index < ansList.size())
            return true;
        
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */