class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int l=0;
        int hi=*max_element(piles.begin(),piles.end());
        int speed=0;
        
        if(h==piles.size())
        return *max_element(piles.begin(),piles.end());
      
            while(l<=hi)

            {
                int sp=0;
                sp=l+(hi-l)/2; // speed of banana eating , here we apply binary search on speed(elements of array, not on index of array) 
                if(ispossible(piles,sp,h)==true)
                {
                     speed=sp;
                    hi=sp-1;
                }
                else{
                    l=sp+1;
                }
            
        }
        return speed;
        
    }
    bool ispossible(vector<int>& piles,int sp, int h)
    {
        double time=0;
        for (int i=0;i<piles.size();i++)
        {
            time+=ceil(piles[i]*1.0/sp);
        }
        return time<=h;
    }
};