class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int count = hm.getOrDefault(arr[i],0);
            hm.put(arr[i],count+1);
            
        }
        int a[] = new int[1001];
        for(int val:hm.values()){
            if(a[val]!=0){
                return false;
            }
            a[val]=1;
        }
        
        return true;
    }
}