/**
 * Created by Dheeraj Kumar Barnwal on 10/09/17.
 */
import java.util.*;
public class Third {
    public int calc(String s, int n){
        int c= 0;
        if (n == 1)
            return 1;
        if (s.charAt(n-1)> '0')
            c =  calc(s, n-1);
        //if(s.charAt(n-2)==){
        //
        //}
        return c;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Third th = new Third();
        String s =sc.next();
        int len=s.length();
        int ans = th.calc(s,len);
    }
}
