class TimeMap {

    Map<String, List<Data>> map;
    
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<Data>());
        
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) 
            return "";
        
        List<Data> list = map.get(key);
        
        for(int i = list.size() - 1; i >= 0; i--)
        {
            if(timestamp == list.get(i).time)
                return list.get(i).val;
            else if(timestamp > list.get(i).time)
                return list.get(i).val;
        }
        
        return "";
    }
}

class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */