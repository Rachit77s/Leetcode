class Solution {
private Map<Integer, Integer> map = new HashMap<>();
private Set<Integer> visited = new HashSet<>();

public int[] groupStrings(String[] words) {
    int groups = 0, maxSize = 0;
    for (String w : words) {
        int mask = 0;
        for (char ch : w.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }
        map.put(mask, map.getOrDefault(mask, 0) + 1);
    }

    for (int k : map.keySet()) {
        int size = dfs(k);
        maxSize = Math.max(maxSize, size);
        if (size > 0) {
            groups++;
        }
    }
    return new int[]{groups, maxSize};
}

private int dfs(int mask) {
    if (!map.containsKey(mask) || !visited.add(mask)) {
        return 0;
    }

    int count = map.get(mask);
    for (int i = 0; i < 26; i++) {
        // add/delete: flips one bit
        count += dfs(mask ^ (1 << i));
        for (int j = i + 1; j < 26; j++) {
            // replace: flips two bits with different values
            if (((mask >> i) & 1) != ((mask >> j) & 1)) {
                count += dfs(mask ^ (1 << i) ^ (1 << j));
            }
        }
    }
    return count;
}
}