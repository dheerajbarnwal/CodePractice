class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> loserMap = new HashMap<>();
        TreeSet<Integer> winner = new TreeSet<>();
        TreeSet<Integer> loser = new TreeSet<>();
        TreeSet<Integer> loser1 = new TreeSet<>();
        for(int i=0;i<matches.length;i++){
            int w = matches[i][0];
            int l = matches[i][1];
            if(!loser1.contains(w)){
                winner.add(w);
            }
            if(winner.contains(l)){
                winner.remove(l);
            }
            
            if(!loser1.contains(l)){
                loser.add(l);
            }else{
                loser.remove(l);
            }
            
            loser1.add(l);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>(winner));
        ans.add(new ArrayList<Integer>(loser));
        
        return ans;
        
    }
}