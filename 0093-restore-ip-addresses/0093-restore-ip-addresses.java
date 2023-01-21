class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
		
		StringBuilder ip = new StringBuilder();
		for(int a = 1 ; a <=3 ; a++){
            for(int b = 1 ; b <=3 ; b++){
                for(int c = 1 ; c <=3 ; c++){
                    for(int d = 1 ; d <=3 ; d++){
                        if(a + b + c + d == s.length()){
                            int n1 = Integer.parseInt(s.substring(0, a));
				            int n2 = Integer.parseInt(s.substring(a, a+b));
				            int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
				            int n4 = Integer.parseInt(s.substring(a+b+c));
                            if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
					            ip.append(n1).append('.').append(n2).append('.')
                                    .append(n3).append('.').append(n4);
					            if(ip.length() == s.length() + 3){
                                    ans.add(ip.toString());
                                }
					            ip.setLength(0);    //reset or clear
				            }
                        }
                    }
                }
            }
        }
		return ans;
    }
}