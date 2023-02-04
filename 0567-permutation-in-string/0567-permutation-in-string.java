class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
        }
        
        String sarr = Arrays.toString(arr);
        //System.out.println(sarr + " " + sarr.length());
        
        for(int i=0;i<=s2.length()-s1.length();i++){
            int[] ans = new int[26];
            
            for(int j=0;j<s1.length();j++){
                ans[s2.charAt(i+j)-'a']++;
                
            }
            
            if(sarr.equals(Arrays.toString(ans))){
                return true;
            }
            
        }
        return false;
    }
}