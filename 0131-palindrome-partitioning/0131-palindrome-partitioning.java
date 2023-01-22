class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(0,ans,new ArrayList<String>(),s);
        return ans;
    }
    
    void dfs(int start, List<List<String>> ans, List<String> curr, String s){
        if(start>=s.length()){
            ans.add(new ArrayList<String>(curr));
            return;
        }
        
        for(int end=start;end<s.length();end++){
            if(isPalindrome(s,start,end)){
                curr.add(s.substring(start,end+1));
                dfs(end+1,ans,curr,s);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int low, int high){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}