/**
 * Created by Dheeraj Kumar Barnwal on 10/09/17.
 */
import java.util.*;
public class One {
    long a[] = new long[1005];
    int n;
    long ans=0;
    public int findMini(int f,int l){
        int ind=f;
        for(int i=f;i<=l;i++){
            if(a[i]<a[ind]){
                ind=i;
            }
        }
        return ind;
    }
    public void update(int f,int l,long val){
        for(int i=f;i<=l;i++){
            a[i]-=val;
        }
    }
    public void calculate(int f,int l){
        if(f>l)
            return;
        int mini=findMini(f,l);
        ans+=a[mini];
        update(f,l,a[mini]);
        calculate(f,mini-1);
        calculate(mini+1,l);
    }
    public static void main(String args[]){
        One o = new One();
        Scanner sc = new Scanner(System.in);
        o.n=sc.nextInt();
        for(int i=0;i<o.n;i++){
            o.a[i]=sc.nextLong();

        }
        o.calculate(0,o.n-1);
        System.out.println(o.ans);
    }
}
