class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> repeat = new HashSet<>();

        for(int i = 0; i + 9 < s.length(); i++) 
        {
            String sub = s.substring(i, i + 10);

            if(!set.contains(sub))
                set.add(sub);
            else
                repeat.add(sub);
        }

        return new ArrayList(repeat);
    }
}