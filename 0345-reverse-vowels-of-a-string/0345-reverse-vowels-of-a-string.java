class Solution {
    public String reverseVowels(String s) {
        List<Character> vow = new ArrayList<>(List.of('a','e','i','o','u','A','E','I','O','U'));
        char[] ch = s.toCharArray();
        int n=ch.length;
        int i=0;
        int j=n-1;
        while(i<j){
            if(!vow.contains(ch[i])){
                i++;
            } else if(!vow.contains(ch[j])){
                j--;
            } else if(vow.contains(ch[i]) && vow.contains(ch[j])){
                char temp = ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
        }
        return String.valueOf(ch);
    }
}