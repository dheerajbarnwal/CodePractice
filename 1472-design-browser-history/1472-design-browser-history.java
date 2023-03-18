class BrowserHistory {
    Map<Integer,String> hm;
    int curr=0;
    int total=0;
    public BrowserHistory(String homepage) {
        hm=new HashMap<>();
        visit(homepage);
    }
    
    public void visit(String url) {
        hm.put(++curr,url);
        total=curr;
    }
    
    public String back(int steps) {
        if(curr-steps>=1){
            curr-=steps;
            return hm.get(curr);
        }
        curr=1;
        return hm.get(1);
    }
    
    public String forward(int steps) {
        if(curr+steps<=total){
            curr+=steps;
            return hm.get(curr);
        }
        curr=total;
        return hm.get(total);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */