class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        dictOfChar = defaultdict(int)
        
        for i in range(97, 123):  # ASCII values of 'a' to 'z' are 97 to 122
            dictOfChar[chr(i)] = 1
            
        dict2 = defaultdict(int)
        for ch in sentence:
            dict2[ch] += 1
            
        for key, value in dictOfChar.items():
            if dict2[key] == 0:
                return False
            
        return True