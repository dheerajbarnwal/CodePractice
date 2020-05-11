import java.util.Scanner;

/**
 * Created by Dheeraj Kumar Barnwal on 10/09/17.
 */
public class Second {
    public static void main(String args[]){
        int a[] = new int[10000007];
        int b[] = new int[10000007];
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m;
        int val;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        m=a[n-1];
        for(int i=n-1;i>=0;i--){
            if(a[i]<=m){
                b[i]=m;
            }else{
                b[i]=a[i];
                m=a[i];
            }
        }
        int max1=0;
        int max2=0;
        for(int i=n-1;i>=0;i--){
            b[i]=b[i]-a[i];
            if(b[i]>max1){
                max2=max1;
                max1=b[i];
            }
        }
        System.out.println(max1);
        System.out.println(max1+max2);
    }
}
