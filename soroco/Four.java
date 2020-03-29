/**
 * Created by Dheeraj Kumar Barnwal on 10/09/17.
 */
import java.util.*;
public class Four {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();
        int b=sc.nextInt();
        int ans=0;
        int i=b-1;

        while(n!=1 && i>=2){
            //i=b-1;
            if(n%i==0){
                ans++;
                n=n/i;
            }else{
                i-=1;
            }
        }
        if(ans==0)
            System.out.print("-1");
        else
            System.out.print(ans);
    }
}
