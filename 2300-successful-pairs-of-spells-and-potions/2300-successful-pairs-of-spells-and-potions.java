class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int l=0,h=potions.length;
            while(l<h){
                int mid = (l+h)/2;
                if(1L*spells[i]*potions[mid]>=success){
                    h=mid;
                }else{
                    l=mid+1;
                }
            }
            spells[i]=potions.length-l;
        }
        return spells;
    }
}