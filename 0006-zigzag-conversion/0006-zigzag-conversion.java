class Solution {
    public String convert(String str, int R) {
            if (R == 1) return str;

    char[] s = str.toCharArray();
    char[] t = new char[s.length];

    for (int i = 0, len = 0; i < R; i++) {
        for (int j = 0, k = i; k < s.length; j++) {
            t[len++] = s[k];
            k += ((i == 0 || j % 2 == 0) && i != R - 1 ? 2 * (R - i - 1) : 2 * i);
        }
    }

    return new String(t);
    }
}