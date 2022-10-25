class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        return Helper(words, k);
    }
    
    public List<String> Helper(String[] words, int k) 
    {
        List<String> ans = new ArrayList<String>();
        if (words == null || words.length == 0) 
        {
            return ans;
        }
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word:words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        // While inserting in pq, if the count of two words is same then insert based on string compare of the keys.
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new MyComparator());
        for(Map.Entry<String, Integer> e:map.entrySet())
            pq.offer(e);
        
        //List<String> ans = new LinkedList<>();
        for(int i = 0;i<=k-1;i++)
            ans.add(pq.poll().getKey());
        
        return ans;
    }
}

public class MyComparator implements Comparator<Map.Entry<String, Integer>>
{
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)
    {
        String w1 = e1.getKey();
        int freq1 = e1.getValue();
        
        String w2 = e2.getKey();
        int freq2 = e2.getValue();
        
        if(freq1 != freq2)
            return freq2-freq1;
        else 
            return w1.compareTo(w2);
    }
}

// @Override
//             public int compare(String s1, String s2) {
//                 if (map.get(s1) == map.get(s2)) {
//                     return s1.compareTo(s2);
//                 }
//                 return map.get(s2) - map.get(s1);
//             }