class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if(n==0)
            return true;
        for(int i=0;i<size;i++){
            if(flowerbed[i]==1)
                continue;
            if(i==0){
                if(i+1>=size || flowerbed[i+1]==0){
                    n--;
                    flowerbed[i]=1;
                }else{
                    continue;
                }
                
            }else if(i==size-1){
                if(flowerbed[i-1]==0){
                    n--;
                    flowerbed[i]=1;
                }else{
                    continue;
                }
            }else if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                n--;
                flowerbed[i]=1;
            }
            if(n==0){
                return true;
            }
        }
        return false;
    }
}