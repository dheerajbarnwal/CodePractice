class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int carry=0;
        String ans="";
        while(m>=0 && n>=0){
            int t=(a.charAt(m)-'0')+(b.charAt(n)-'0')+carry;
            String output="";
            if(t==0 || t==1){
                output=String.valueOf(t);
                carry=0;
            }else if(t==2){
                output="0";
                carry=1;
            }else if(t==3){
                output="1";
                carry=1;
            }
            ans=output+ans;
            m--;
            n--;
        }
        
        while(m>=0){
            int t=(a.charAt(m)-'0')+carry;
            String output="";
            if(t==0 || t==1){
                output=String.valueOf(t);
                carry=0;
            }else if(t==2){
                output="0";
                carry=1;
            }
            ans=output+ans;
            m--;
        }
        while(n>=0){
            int t=(b.charAt(n)-'0')+carry;
            String output="";
            if(t==0 || t==1){
                output=String.valueOf(t);
                carry=0;
            }else if(t==2){
                output="0";
                carry=1;
            }
            ans=output+ans;
            n--;
        }
        if(carry==1){
            ans="1"+ans;
        }
        return ans;
        
    }
}