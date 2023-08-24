class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        n = len(words)
        def greedySingle(idx):
            nonlocal maxWidth, n
            cur_len = len(words[idx])
            cur_idx = idx
            single = [words[idx]]
            while cur_idx+1 < n and cur_len + len(words[cur_idx+1]) + 1 <= maxWidth:
                single.append(" " + words[cur_idx+1])
                cur_len = cur_len + len(words[cur_idx+1]) + 1
                cur_idx += 1
            
            if len(single) > 1 and cur_idx != n - 1:
                avg_pad = (maxWidth - cur_len) // (len(single) - 1)
                rmd_pad = maxWidth - cur_len - avg_pad * (len(single) - 1)
                for i in range(1, len(single)):
                    single[i] = (" " * avg_pad + single[i])
                    if i < 1 + rmd_pad:
                        single[i] = " " + single[i]
            else:
                single.append(" " * (maxWidth - cur_len))
            
            return "".join(single), cur_idx + 1
        
        res = []
        begin_idx = 0
        while begin_idx < n:
            single_str, begin_idx = greedySingle(begin_idx)
            res.append(single_str)
        return res