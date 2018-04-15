import java.util.Stack;

/**
 * Created by Dheeraj Kumar Barnwal on 15/04/18.
 * Remove brackets from an algebraic string containing + and – operators
 */
public class Simplify {
    public static String simplify(String s){
        String res="";
        Stack<Integer> st = new Stack<>();
        int prev;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                prev=i-1;       //check previous character
                if(prev >= 0){
                    if(s.charAt(prev)=='-'){
                        if(!st.isEmpty() && st.peek()==1)
                            st.push(0);
                        else
                            st.push(1);
                    }else{  // if previous character is '+' or '('
                        if(!st.isEmpty() && st.peek()==1)
                            st.push(1);
                        else
                            st.push(0);
                    }
                }else{
                    st.push(0);
                }
            }else if(Character.isLetter(s.charAt(i))){
                res+=s.charAt(i);
            }else if(s.charAt(i)==')'){
                st.pop();
            }else if(!st.isEmpty() && st.peek()==1){
                if(s.charAt(i)=='-'){
                    res+='+';
                }else{
                    res+='-';
                }
            }else{
                res+=s.charAt(i);
            }
        }
        return res;
    }
    public static void main(String args[]){
        String s1="((a+b-c))";
        String s2="a-(b-c-(d+e))-f";
        String s3="a+b-((c+d)-m)";
        System.out.println(simplify(s1));
        System.out.println(simplify(s2));
        System.out.println(simplify(s3));
    }
}
