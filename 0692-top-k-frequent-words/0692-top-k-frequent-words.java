class Solution {
    
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<WordFreq> pq = new PriorityQueue(k, new WordComparator());
        Map<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        
        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            WordFreq wf1 = new WordFreq(entry.getKey(), entry.getValue());
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if(pq.size()==k){
                //System.out.println(pq.peek().word);
                if(entry.getValue()<pq.peek().count){
                    continue;
                }else if(entry.getValue()==pq.peek().count && entry.getKey().compareTo(pq.peek().word)>0){
                    //System.out.println(entry.getKey());
                    continue;
                }
                pq.poll();
            }
            pq.add(wf1);
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }
}

class WordFreq{
        String word;
        int count;
        WordFreq(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
class WordComparator implements Comparator<WordFreq>{
    public int compare(WordFreq w1, WordFreq w2){
        if(w1.count==w2.count){
            return w2.word.compareTo(w1.word);
        }
        return w1.count-w2.count;
    }
}

