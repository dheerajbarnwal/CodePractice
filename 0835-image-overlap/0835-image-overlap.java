class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        Map<String,Integer> hm = new HashMap<>();
        int n = img1.length;
        List<Pair<Integer,Integer>> list1 = new ArrayList<>();
        List<Pair<Integer,Integer>> list2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1){
                    list1.add(new Pair(i,j));
                }
                if(img2[i][j]==1){
                    list2.add(new Pair(i,j));
                }
            }
        }
        int max=0;
        
        for(Pair<Integer,Integer> pair1:list1){
            for(Pair<Integer,Integer> pair2:list2){
                String key = (pair2.getKey()-pair1.getKey()) + " " + (pair2.getValue()-pair1.getValue());
                //hm.put(key, hm.getOrDefault(key,0)+1);
                int val = hm.getOrDefault(key,0);
                max = Math.max(max,val+1);
                hm.put(key,val+1);
            }
        }
        return max;
        
    }
}