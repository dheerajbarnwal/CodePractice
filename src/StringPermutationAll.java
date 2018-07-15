import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Dheeraj Kumar Barnwal on 15/07/18.
 *
 * Given a string S, print all ‘Special Subsequences’ of S. A special subsequence is a subsequence of given string with capital letters allowed.
 * Example:
 * Input : ab
 * Output: A AB Ab B a aB ab b
 */
public class StringPermutationAll {
    static Set<String> res;
    public static void init(){
        res = new LinkedHashSet<>();
    }
    public static void generate(String s,int n,int i,String curr){

        if(i==n){
            return;
        }
        if(curr.length()!=0)
            res.add(curr);
        for(int j=i+1;j<n;j++){
            curr+=s.charAt(j);
            generate(s,n,j,curr);
            curr = curr.substring(0,curr.length()-1);
        }
        for(int j=i+1;j<n;j++){
            curr+=Character.toUpperCase(s.charAt(j));
            generate(s,n,j,curr);
            curr = curr.substring(0,curr.length()-1);
        }
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            String s = sc.next();
            int len = s.length();
            init();
            generate(s,len,-1,"");
            //Collections.sort(test.res);
            System.out.println((int)Math.pow(3,len)-1);
            int flag=0;

            for(String ans:res){
                if(flag==0){
                    System.out.print(ans);
                    flag=1;
                }else{
                    System.out.print(" " + ans);
                }

            }

            System.out.println();
        }

    }
}
