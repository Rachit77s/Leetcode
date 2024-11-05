class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        for i in range(len(sentence)):
            #check on space
            if sentence[i] == " " and sentence[i-1] != sentence[i+1]:
                return False
            
        return sentence[0] == sentence[-1]