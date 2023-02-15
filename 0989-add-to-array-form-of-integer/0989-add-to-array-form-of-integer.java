class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> kk = new ArrayList<>();
        while(k!=0){
            kk.add(0,k%10);
            k/=10;
        }
        //System.out.println(kk);
        List<Integer> ans = new ArrayList<>();
        int carry=0;
        int i=num.length-1;
        int j=kk.size()-1;
        while(i>=0 && j>=0){
            int t = num[i--]+kk.get(j--)+carry;
            ans.add(0,t%10);
            carry=t/10;
        }
        
        while(i>=0){
            int t = num[i--]+carry;
            ans.add(0,t%10);
            carry=t/10;
        }
        while(j>=0){
            int t = kk.get(j--)+carry;
            ans.add(0,t%10);
            carry=t/10;
        }
        if(carry>0){
            ans.add(0,carry);
        }
        return ans;
    }
}