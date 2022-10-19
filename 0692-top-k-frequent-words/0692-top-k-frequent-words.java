class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue(k, new WordComparator());
        Map<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        
        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            if(pq.size()==k){
                if(entry.getValue()<pq.peek().getValue() || (entry.getValue()==pq.peek().getValue() && entry.getKey().compareTo(pq.peek().getKey())>0)){
                    continue;
                }
                pq.poll();
            }
            pq.add(entry);
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.poll().getKey());
        }
        return ans;
    }
}

class WordComparator implements Comparator<Map.Entry<String,Integer>>{
    public int compare(Map.Entry<String,Integer> w1, Map.Entry<String,Integer> w2){
        if(w1.getValue()==w2.getValue()){
            return w2.getKey().compareTo(w1.getKey());
        }
        return w1.getValue()-w2.getValue();
    }
}

