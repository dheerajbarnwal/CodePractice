import java.util.Stack;

/**
 * Created by Dheeraj Kumar Barnwal on 15/04/18.
 * Remove brackets from an algebraic string containing + and – operators
 */
public class Simplify {
    public static String simplify(String s){
        StringBuilder res = new StringBuilder() ;
        Stack<Integer> st = new Stack<>();
        int prev;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){

                /*check operators just before starting of bracket means '('.
                 If operator is -, we need to toggle all operators inside the bracket
                 So, here I have used 0 and 1 in stack to indicate if an operator comes inside this bracket need to toggle or not in the result.
                 0 : Not toggle
                 1 : toggle

                 stack.push when character '('
                 stack.pop when character ')'   */

                prev=i-1;
                if(prev >= 0){
                    if(s.charAt(prev)=='-'){
                        if(!st.isEmpty() && st.peek()==1)
                            st.push(0);
                        else
                            st.push(1);
                    }else{                      // if previous character is '+' or '('
                        if(!st.isEmpty() && st.peek()==1)
                            st.push(1);
                        else
                            st.push(0);
                    }
                }else{                   //it will handle only the case when string starts with '('
                    st.push(0);
                }
            }else if(Character.isLetter(s.charAt(i))){
                res.append(s.charAt(i));
            }else if(s.charAt(i)==')'){
                st.pop();
            }else if(!st.isEmpty() && st.peek()==1){  // Toggle here on the basis of top of stack
                if(s.charAt(i)=='-'){
                    res.append('+');
                }else{
                    res.append('-');
                }
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
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
