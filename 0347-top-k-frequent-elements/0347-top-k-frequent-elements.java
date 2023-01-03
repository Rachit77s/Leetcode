class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        return BucketSort(nums, k);
        // return Helper(nums, k);
    }
    
    public int[] BucketSort(int[] A, int k)
    {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for(int num: A)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        
        
        // Bucket will contain HM frequency and List of keys
        // i.e We will store reverse of HM  --> <Value, Key>
        
        // We cannot use Pair class, we need to use Array
        // Pair<Integer, List<Integer>> bucker = new Pair<>(integer, list);
        
        List<Integer>[] bucket = new List[A.length + 1];
        
        for (int key : frequencyMap.keySet())
        {
            int frequency = frequencyMap.get(key);
            
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();

            bucket[frequency].add(key);
        }
        
        int[] ans = new int[k];
        int idx = 0;
        
        // Iterate from the last because the bucket contains the HM freq as key
        for (int pos = bucket.length - 1; pos >= 0; pos--) 
        {
            
            if (bucket[pos] != null) 
            {
                for(int j = 0; j < bucket[pos].size(); j++)
                {                                 
                    ans[idx] = bucket[pos].get(j);
                    idx++;
                }
            }
            
            if(idx == k)
                break;
		}
        

	    return ans;
    }
    
    public int[] Helper(int[] A, int k)
    {
        int[] ans = new int[k];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: A)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        // While inserting in pq, if the count of two words is same then insert based on string compare of the keys.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new MyComparator());
        
        for(Map.Entry<Integer, Integer> e : map.entrySet())
            pq.offer(e);
        
        for(int i = 0; i < k; i++)
            ans[i] = (pq.poll().getKey());
        
        return ans;
        
    }
    
    public class MyComparator implements Comparator<Map.Entry<Integer, Integer>>
    {
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2)
        {
            int w1 = e1.getKey();
            int freq1 = e1.getValue();

            int w2 = e2.getKey();
            int freq2 = e2.getValue();

            if(freq1 != freq2)
                return freq2-freq1;
            else 
                return freq1 - freq2;
        }
    }
}