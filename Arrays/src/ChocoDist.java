import java.util.*;

/**
 * Chocolate Distribution Problem
 * Given an array A[] of N integers where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are m students, the task is to distribute chocolate packets such that :
 1. Each student gets one packet.
 2. The difference between the number of chocolates given to the students in packet with maximum chocolates and packet with minimum chocolates is minimum.
 */
public class ChocoDist {
    private static int getMin(int a[],int n,int m){
        int ans = Integer.MAX_VALUE;
        Arrays.sort(a);
        for(int i=0;i<=n-m;i++){
            int temp=a[i+m-1]-a[i];
            if(temp<ans){
                ans=temp;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a[];
        int ans;
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            int m = sc.nextInt();
            ans = getMin(a,n,m);
            System.out.println(ans);
        }
    }
}
